package frontend;

import java.io.IOException;

/**
 * Represents a semantic unit of the target language to be
 * used by the parser and scanner.
 */
public abstract class Token {

    protected Source source;
    protected String text;
    protected Object value;
//    protected TokenType type;
    private int lineNum;
    private int position;

    // TODO:
    protected abstract void extract();

    protected char currentChar() throws IOException {
        return source.currentChar();
    }

    protected char nextChar() throws IOException {
        return source.nextChar();
    }

    // TODO:
    protected char peekChar() {
        return ' ';
    }
}
