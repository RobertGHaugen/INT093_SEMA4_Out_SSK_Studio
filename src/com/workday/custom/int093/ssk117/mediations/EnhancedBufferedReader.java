package com.workday.custom.int093.ssk117.mediations;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import com.workday.custom.int093.ssk117.Constants;

/**
 * A special buffered reader which supports sophisticated read access.
 * <p>
 * In particular the reader supports a look-ahead option, which allows you to see the next char returned by
 * {@link #read()}. This reader also tracks how many characters have been read with {@link #getPosition()}.
 * </p>
 * <p>
 * This class was sourced from Apache Commons CSV 1.8 and then further modified for Workday SSK.
 * </p>
 */
// This class based upon and inspired by org.apache.commons.csv.ExtendedBufferedReader.  
// The original source code and its here-in redistribution are licensed under Apache License 2.0.  The license may be obtained for review at http://www.apache.org/licenses/LICENSE-2.0.
// The original source code has been modified for the specific purposes of the Workday Studio StarterKit.
public final class EnhancedBufferedReader extends BufferedReader {

    /** The last char returned */
    private int lastChar = Constants.UNDEFINED;

    /** The count of EOLs (CR/LF/CRLF) seen so far */
    private long eolCounter;

    /** The position, which is number of characters read so far */
    private long position;

    private boolean closed;

    /**
     * Created extended buffered reader using default buffer-size
     */
    public EnhancedBufferedReader(final Reader reader) {
        super(reader);
    }

    @Override
    public int read() throws IOException {
        final int current = super.read();
        if (current == Constants.CR || current == Constants.LF && lastChar != Constants.CR) {
            eolCounter++;
        }
        lastChar = current;
        this.position++;
        return lastChar;
    }

    /**
     * Returns the last character that was read as an integer (0 to 65535). This will be the last character returned by
     * any of the read methods. This will not include a character read using the {@link #lookAhead()} method. If no
     * character has been read then this will return {@link Constants#UNDEFINED}. If the end of the stream was reached
     * on the last read then this will return {@link Constants#END_OF_STREAM}.
     *
     * @return the last character that was read
     */
    public int getLastChar() {
        return lastChar;
    }

    @Override
    public int read(final char[] buf, final int offset, final int length) throws IOException {
        if (length == 0) {
            return 0;
        }

        final int len = super.read(buf, offset, length);

        if (len > 0) {

            for (int i = offset; i < offset + len; i++) {
                final char ch = buf[i];
                if (ch == Constants.LF) {
                    if (Constants.CR != (i > 0 ? buf[i - 1] : lastChar)) {
                        eolCounter++;
                    }
                } else if (ch == Constants.CR) {
                    eolCounter++;
                }
            }

            lastChar = buf[offset + len - 1];

        } else if (len == -1) {
            lastChar = Constants.END_OF_STREAM;
        }

        position += len;
        return len;
    }

    /**
     * Calls {@link BufferedReader#readLine()} which drops the line terminator(s). This method should only be called
     * when processing a comment, otherwise information can be lost.
     * <p>
     * Increments {@link #eolCounter}
     * <p>
     * Sets {@link #lastChar} to {@link Constants#END_OF_STREAM} at EOF, otherwise to LF
     *
     * @return the line that was read, or null if reached EOF.
     */
    @Override
    public String readLine() throws IOException {
        final String line = super.readLine();

        if (line != null) {
            lastChar = Constants.LF; // needed for detecting start of line
            eolCounter++;
        } else {
            lastChar = Constants.END_OF_STREAM;
        }

        return line;
    }

    /**
     * Returns the next character in the current reader without consuming it. So the next call to {@link #read()} will
     * still return this value. Does not affect line number or last character.
     *
     * @return the next character
     *
     * @throws IOException
     *             if there is an error in reading
     */
    public int lookAhead() throws IOException {
        super.mark(1);
        final int c = super.read();
        super.reset();

        return c;
    }

    /**
     * Returns the current line number
     *
     * @return the current line number
     */
    public long getCurrentLineNumber() {
        // Check if we are at EOL or EOF or just starting
        if (lastChar == Constants.CR || lastChar == Constants.LF || lastChar == Constants.UNDEFINED || lastChar == Constants.END_OF_STREAM) {
            return eolCounter; // counter is accurate
        }
        return eolCounter + 1; // Allow for counter being incremented only at EOL
    }

    /**
     * Gets the character position in the reader.
     *
     * @return the current position in the reader (counting characters, not bytes since this is a Reader)
     */
    public long getPosition() {
        return this.position;
    }

    public boolean isClosed() {
        return closed;
    }

    /**
     * Closes the stream.
     *
     * @throws IOException
     *             If an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        // Set ivars before calling super close() in case close() throws an IOException.
        closed = true;
        lastChar = Constants.END_OF_STREAM;
        super.close();
    }

}
