package frontend;

import java.io.IOException;

/**
 * Lexically analyzes input and creates tokens for usage
 * by the parser.
 */
public abstract class Scanner {

    private Token currentToken;
    protected Source source;

    public Scanner(Source source) {
        this.source = source;
    }

    public Token currentToken() {
        return currentToken;
    }

    public Token nextToken() throws IOException {
        currentToken = extractToken();
        return currentToken;
    }

    protected abstract Token extractToken() throws IOException;


    public char currentChar() throws IOException {
        return source.currentChar();
    }

    public char nextChar() throws IOException {
        return source.nextChar();
    }
}
