package frontend;

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
    protected Token extractToken() {
        return currentToken;
    }

    public char currentChar() {
        return source.currentChar();
    }

    public char nextChar() {
        return source.nextChar();
    }
}
