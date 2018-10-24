package frontend.pascal;

import frontend.*;
import java.io.*;
import message.*;

import static message.MessageType.PARSER_SUMMARY;

public class PascalParserTD extends Parser {

    public PascalParserTD(Scanner scanner) {
        super(scanner);
    }

    public void parse() throws IOException {
        Token token;
        long startTime = System.currentTimeMillis();

        while(!((token = nextToken()) instanceof EofToken)) {}

        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        sendMessage(
                new Message(PARSER_SUMMARY,
                new Number[]{ token.getLineNumber(), getErrorCount(), elapsedTime}));

    }

    public int getErrorCount() {
        return 0;
    }
}
