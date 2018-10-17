package frontend;

public abstract class Token {

    protected Source source;
    protected String text;
    protected Object value;
//    protected TokenType type;
    private int lineNum;
    private int position;

    // TODO:
    protected abstract void extract();

    protected char currentChar() {
        return source.currentChar();
    }

    protected char nextChar() {
        return source.nextChar();
    }

    // TODO:
    protected char peekChar() {
        return ' ';
    }
}
