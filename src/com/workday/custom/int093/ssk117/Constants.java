package com.workday.custom.int093.ssk117;
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

/**
 * Constants for this package.
 */
public final class Constants {

	public static final char BACKSLASH = '\\';

	public static final char COMMA = ',';

	public static final char PIPE = '|';

    /**
     * Starts a comment, the remainder of the line is the comment.
     */
	public static final char COMMENT = '#';

	public static final char CR = '\r';

	public static final Character DOUBLE_QUOTE_CHAR = Character.valueOf('"');

	public static final Character UNDERSCORE = Character.valueOf('_');

	public static final Character HYPHEN = Character.valueOf('-');

	public static final Character PERIOD = Character.valueOf('.');

	public static final String EMPTY = "";

    /** The end of stream symbol */
	public static final int END_OF_STREAM = -1;

	public static final char FF = '\f';

	public static final char LF = '\n';

	public static final char BACKSPACE = '\b';

	public static final char TAB = '\t';

	public static final char SP = ' ';

    /** RFC 4180 defines line breaks as CRLF */
	public static final String CRLF = "\r\n";
    public static final String CR_STRING = Character.toString(CR);
    public static final String LF_STRING = Character.toString(LF);

    /**
     * Unicode line separator.
     */
	public static final String LINE_SEPARATOR = "\u2028";

    /**
     * Unicode next line.
     */
	public static final String NEXT_LINE = "\u0085";

    /**
     * Unicode paragraph separator.
     */
	public static final String PARAGRAPH_SEPARATOR = "\u2029";

    /** ASCII record separator */
	public static final char RS = 30;

    /** Undefined state for the lookahead char */
	public static final int UNDEFINED = -2;

    /** ASCII unit separator */
	public static final char US = 31;

}