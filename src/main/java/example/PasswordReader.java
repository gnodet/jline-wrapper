/*
 * Copyright (c) 2002-2016, the original author or authors.
 *
 * This software is distributable under the BSD license. See the terms of the
 * BSD license in the documentation provided with this software.
 *
 * http://www.opensource.org/licenses/bsd-license.php
 */

package example;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class PasswordReader {
    public static void usage() {
        System.out.println("Usage: java "
            + PasswordReader.class.getName() + " [mask]");
    }

    public static void main(String[] args) throws IOException {
        Terminal terminal = TerminalBuilder.terminal();
        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal).build();

        Character mask = (args.length == 0)
            ? (char) 0
            : args[0].charAt(0);

        String line;
        do {
            line = reader.readLine("Enter password> ", mask);
            System.out.println("Got password: " + line);
        }
        while (line != null && line.length() > 0);
    }
}
