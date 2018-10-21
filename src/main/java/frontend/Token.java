package frontend;

import java.io.IOException;

/**
 * Represents a semantic unit of the target language to be
 * used by the parser and scanner.
 */
public class Token {

    protected Source source;
    protected String text;
    protected Object value;
    protected TokenType type;
    private int lineNum;
    private int position;

    public Token(Source source) throws IOException {
        this.source = source;
        this.lineNum = source.getLineNum();
        this.position = source.getPosition();

        extract();
    }

    protected void extract() throws IOException {
        text = Character.toString(currentChar());
        value = null;

        nextChar();
    }

    protected char currentChar() throws IOException {
        return source.currentChar();
    }

    protected char nextChar() throws IOException {
        return source.nextChar();
    }

    protected char peekChar() throws IOException {
        return source.peekChar();
    }
}
