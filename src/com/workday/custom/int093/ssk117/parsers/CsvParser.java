package com.workday.custom.int093.ssk117.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.capeclear.logger.LogControl;
import com.capeclear.logger.Logger;
import com.workday.custom.int093.ssk117.Constants;
import com.workday.custom.int093.ssk117.mediations.EnhancedBufferedReader;

// Sections of this class are taken/modified from org.apache.commons.csv.CSVParser and Lexer, under Apache License 2.0
public class CsvParser implements IParser {
	private Logger log = LogControl.getLogger(getClass());

	private char fieldSeparator;
	
	private EnhancedBufferedReader reader;
	private String[] next;
	
	private int fieldCount = -1;
	private String endOfLine = null;
	
	public void setFieldSeparator(String fieldSeparator) {
		this.fieldSeparator = fieldSeparator.charAt(0);
	}

	public CsvParser() {
		super();
	}

	@Override
	public void setReader(EnhancedBufferedReader reader) {
		this.reader = reader;
		moveToNext();
	}

	@Override
	public String[] getHeaders(boolean isFirstRowHeader) throws Exception {
		String[] returnValue = null;
		
		if (next != null) {
			if (isFirstRowHeader) {
				returnValue = next;
				moveToNext();
			} else {
				returnValue = new String[next.length];
				for (int i = 0; i < next.length; i++) {
					returnValue[i] = "col" + (i + 1); 
				}
			}

			fieldCount = returnValue.length;
		}
		
		return returnValue;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public String[] next() {
		if (next == null) {
			throw new NoSuchElementException("No more rows are available");
		}
		
		String[] returnValue = next;
		moveToNext();
		
		return returnValue;
	}

	private void moveToNext() {
		try {
			next = parseNextLine();
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
			throw new RuntimeException(t.getMessage(), t);
		}
	}
	
	private String[] parseNextLine() throws Exception {
		List<String> returnValue = null;
		int columnPointer = 0;

        StringBuilder fieldContent = new StringBuilder();

		int lastChar;
		
		while (true) {
			// get the last read char (required for empty line detection)
	        lastChar = reader.getLastChar();
			
	        // read the next char and set eol
	        int c = reader.read();

	        /*
	         * Note: The following call will swallow LF if c == CR. But we don't need to know if the last char was CR or LF
	         * - they are equivalent here.
	         */
	        boolean eol = readEndOfLine(c);

	        // empty line detection: eol AND (last char was EOL or beginning)
	        boolean isEOF = false;
	        while (eol && isStartOfLine(lastChar)) {
                // go one char ahead ...
                lastChar = c;
                c = reader.read();
                eol = readEndOfLine(c);
                
                if (isEndOfFile(c)) {
                	isEOF = true;
                	break;
                }
            }

	        // did we reach eof during the last iteration already ? EOF
	        if (isEOF || isEndOfFile(lastChar) || !isDelimiter(lastChar) && isEndOfFile(c)) {
	            break;
	        }

	        if (isStartOfLine(lastChar) && isCommentStart(c)) {
	            final String line = reader.readLine();
	            log.info("Skipping comment on line (" + getCurrentLineNumber() + ").");
	            
	            if (line == null) {
	            	// reached eof
	            	break;
	            }
	        }
	        
	        returnValue = new ArrayList<String>();
	        
	        while (true) {
	        	if (eol || readEndOfLine(c)) {
	        		break;
	        	} else if (isDelimiter(c)) {
	        		returnValue.add(fieldContent.toString());
	        		columnPointer++;
	        		fieldContent.setLength(0);
	        		c = reader.read();
	        	} else if (isEndOfFile(c)) {
	        		isEOF = true;
	        		break;
	        	} else if (isQuoteChar(c)) {
	        		eol = parseEncapsulatedToken(fieldContent, columnPointer);
	        		returnValue.add(fieldContent.toString());
	        		columnPointer++;
	        		fieldContent.setLength(0);
	        		
	        		if (!eol) {
	        			c = reader.read();
	        		}
	        	} else {
	        		eol = parseSimpleToken(fieldContent, columnPointer, c);
	        		returnValue.add(fieldContent.toString());
	        		columnPointer++;
	        		fieldContent.setLength(0);
	        		
	        		if (!eol) {
	        			c = reader.read();
	        		}
	        	}
	        }
	        
	        if (isEOF || eol) {
	        	break;
	        }
		}
		
		if (fieldCount == -1 && columnPointer > 0) {
			fieldCount = columnPointer;
		} else if (fieldCount != columnPointer && columnPointer > 0) {
			throw new Exception("Expected file to have "+ fieldCount +" number of columns, but line "+ reader.getCurrentLineNumber() +" had "+ columnPointer +" column(s).  All rows must have the same number of columns to be well-formed CSV data.");
		}

        return returnValue == null ? null : returnValue.toArray(new String[0]); 
	}
	
    /**
     * Greedily accepts \n, \r and \r\n This checker consumes silently the second control-character...
     *
     * @return true if the given or next character is a line-terminator
     */
    private boolean readEndOfLine(int ch) throws IOException {
        // check if we have \r\n...
        if (ch == Constants.CR && reader.lookAhead() == Constants.LF) {
            // note: does not change ch outside of this method!
            ch = reader.read();
            // Save the EOL state
            if (endOfLine == null) {
            	endOfLine = Constants.CRLF;
            }
        }
        // save EOL state here.
        if (endOfLine == null) {
            if (ch == Constants.LF) {
                endOfLine = Constants.LF_STRING;
            } else if (ch == Constants.CR) {
                endOfLine = Constants.CR_STRING;
            }
        }

        return ch == Constants.LF || ch == Constants.CR;
    }

    /**
     * @return true if the given char is a whitespace character
     */
    private boolean isWhitespace(final int ch) {
        return !isDelimiter(ch) && Character.isWhitespace((char) ch);
    }

    /**
     * Checks if the current character represents the start of a line: a CR, LF or is at the start of the file.
     *
     * @param ch the character to check
     * @return true if the character is at the start of a line.
     */
    private boolean isStartOfLine(final int ch) {
        return ch == Constants.LF || ch == Constants.CR || ch == Constants.UNDEFINED;
    }

    /**
     * @return true if the given character indicates end of file
     */
    private boolean isEndOfFile(final int ch) {
        return ch == Constants.END_OF_STREAM;
    }

    private boolean isDelimiter(final int ch) {
        return ch == fieldSeparator;
    }

    private boolean isEscape(final int ch) {
        return ch == Constants.BACKSLASH;
    }

    private boolean isQuoteChar(final int ch) {
        return ch == Constants.DOUBLE_QUOTE_CHAR;
    }

    private boolean isCommentStart(final int ch) {
        return ch == Constants.COMMENT;
    }

    private boolean isMetaChar(final int ch) {
        return ch == fieldSeparator ||
               ch == Constants.BACKSLASH ||
               ch == Constants.DOUBLE_QUOTE_CHAR ||
               ch == Constants.COMMENT;
    }

    /**
     * Handle an escape sequence.
     * The current character must be the escape character.
     * On return, the next character is available by calling {@link ExtendedBufferedReader#getLastChar()}
     * on the input stream.
     *
     * @return the unescaped character (as an int) or {@link Constants#END_OF_STREAM} if char following the escape is
     *      invalid.
     * @throws IOException if there is a problem reading the stream or the end of stream is detected:
     *      the escape character is not allowed at end of stream
     */
    int readEscape() throws IOException {
        // the escape char has just been read (normally a backslash)
        final int ch = reader.read();
        
        switch (ch) {
	        case 'r':
	            return Constants.CR;
	        case 'n':
	            return Constants.LF;
	        case 't':
	            return Constants.TAB;
	        case 'b':
	            return Constants.BACKSPACE;
	        case 'f':
	            return Constants.FF;
	        case Constants.CR:
	            return ch;
	        case Constants.LF:
	            return ch;
	        case Constants.FF: // TODO is this correct?
	            return ch;
	        case Constants.TAB: // TODO is this correct? Do tabs need to be escaped?
	            return ch;
	        case Constants.BACKSPACE: // TODO is this correct?
	            return ch;
	        case Constants.END_OF_STREAM:
	            throw new IOException("EOF whilst processing escape sequence");
	        default:
	            // Now check for meta-characters
	            if (isMetaChar(ch)) {
	                return ch;
	            }
	            // indicate unexpected char - available from in.getLastChar()
	            return Constants.END_OF_STREAM;
	    }
    }

    /**
     * Returns the current line number
     *
     * @return the current line number
     */
    long getCurrentLineNumber() {
        return reader.getCurrentLineNumber();
    }

    /**
     * Parses a simple token.
     * <p/>
     * Simple token are tokens which are not surrounded by encapsulators. A simple token might contain escaped
     * delimiters (as \, or \;). The token is finished when one of the following conditions become true:
     * <ul>
     * <li>end of line has been reached (EORECORD)</li>
     * <li>end of stream has been reached (EOF)</li>
     * <li>an unescaped delimiter has been reached (TOKEN)</li>
     * </ul>
     *
     * @param token
     *            the current token
     * @param ch
     *            the current character
     * @return the filled token
     * @throws IOException
     *             on stream access error
     */
    private boolean parseSimpleToken(StringBuilder fieldContent, int columnPointer, int ch) throws IOException {
    	boolean returnValue = false;
    	
        while (true) {
            if (readEndOfLine(ch) || isEndOfFile(ch)) {
            	returnValue = true;
                break;
            } else if (isDelimiter(ch)) {
                break;
            } else if (isEscape(ch)) {
                final int unescaped = readEscape();
                if (unescaped == Constants.END_OF_STREAM) { // unexpected char after escape
                    fieldContent.append((char) ch).append((char) reader.getLastChar());
                } else {
                    fieldContent.append((char) unescaped);
                }
                ch = reader.read(); // continue
            } else {
                fieldContent.append((char) ch);
                ch = reader.read(); // continue
            }
        }
        
        return returnValue;
    }

    /**
     * Parses an encapsulated token.
     * <p/>
     * Encapsulated tokens are surrounded by the given encapsulating-string. The encapsulator itself might be included
     * in the token using a doubling syntax (as "", '') or using escaping (as in \", \'). Whitespaces before and after
     * an encapsulated token are ignored. The token is finished when one of the following conditions become true:
     * <ul>
     * <li>an unescaped encapsulator has been reached, and is followed by optional whitespace then:</li>
     * <ul>
     * <li>delimiter (TOKEN)</li>
     * <li>end of line (EORECORD)</li>
     * </ul>
     * <li>end of stream has been reached (EOF)</li> </ul>
     *
     * @param token
     *            the current token
     * @return a valid token object
     * @throws IOException
     *             on invalid state: EOF before closing encapsulator or invalid character before delimiter or EOL
     */
    private boolean parseEncapsulatedToken(StringBuilder fieldContent, int columnPointer) throws IOException {
    	boolean returnValue = false;

    	// save current line number in case needed for IOE
        final long startLineNumber = getCurrentLineNumber();
        int c;
        while (true) {
            c = reader.read();

            if (isEscape(c)) {
                final int unescaped = readEscape();
                if (unescaped == Constants.END_OF_STREAM) { // unexpected char after escape
                    fieldContent.append((char) c).append((char) reader.getLastChar());
                } else {
                    fieldContent.append((char) unescaped);
                }
            } else if (isQuoteChar(c)) {
                if (isQuoteChar(reader.lookAhead())) {
                    // double or escaped encapsulator -> add single encapsulator to token
                    c = reader.read();
                    fieldContent.append((char) c);
                } else {
                    // token finish mark (encapsulator) reached: ignore whitespace till delimiter
                    while (true) {
                        c = reader.read();
                        if (isDelimiter(c)) {
                        	break;
                        } else if (isEndOfFile(c) || readEndOfLine(c)) {
                        	returnValue = true;
                        	break;
                        } else if (!isWhitespace(c)) {
                            // error invalid char between token and next delimiter
                            throw new IOException("Invalid character found between quoted field and next delimiter on line " + getCurrentLineNumber() + " at field " + (columnPointer + 1));
                        }
                    }
                    break;
                }
            } else if (isEndOfFile(c)) {
                // error condition (end of file before end of token)
                throw new IOException("EOF reached before quoted field finished on " + startLineNumber +" at field " + (columnPointer + 1));
            } else {
                // consume character
                fieldContent.append((char) c);
            }
        }
        
        return returnValue;
    }
}
