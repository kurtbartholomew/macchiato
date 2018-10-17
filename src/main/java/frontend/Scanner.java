package frontend;

import java.io.IOException;

/**
 * Lexically analyzes input and creates tokens for usage
 * by the parser.
 */
public class Scanner {

    private Token currentToken;
    protected Source source;

    public Token currentToken() {
        return currentToken;
    }

    // TODO:
    public Token nextToken() {
        return currentToken;
    }

    // TODO:
    protected Token extractToken() throws IOException {
        return currentToken;
    }

    public char currentChar() throws IOException {
        return source.currentChar();
    }

    public char nextChar() throws IOException {
        return source.nextChar();
    }
}
