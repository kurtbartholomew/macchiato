package frontend;

import java.io.BufferedReader;

public class Source {

    private BufferedReader reader;
    private String line;
    private int lineNum;
    private int currentPos;

    // TODO:
    public char currentChar() {
        return line.charAt(currentPos);
    }

    // TODO:
    public char nextChar() {
        return line.charAt(currentPos+1);
    }
}
