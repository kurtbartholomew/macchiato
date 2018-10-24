package frontend;

import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;

import java.io.BufferedReader;
import java.io.IOException;

import static message.MessageType.SOURCE_LINE;

/**
 * Wrapper around source file(s) to extract characters
 * and tokens.
 */
public class Source implements MessageProducer {

    public static final char EOL = '\n';
    public static final char EOF = (char) 0;
    public static final int SOURCE_NOT_INITIALIZED = -2;
    public static final int LINE_NOT_INITIALIZED = -1;

    protected static MessageHandler messageHandler = new MessageHandler();

    private BufferedReader reader;
    private String line;
    private int lineNum;
    private int currentPos;

    public Source(BufferedReader reader) {
        this.reader = reader;
        this.lineNum = 0;
        this.currentPos = SOURCE_NOT_INITIALIZED;
    }

    public int getLineNum() {
        return this.lineNum;
    }

    public int getPosition() {
        return this.currentPos;
    }

    public char currentChar() throws IOException {
        if(currentPos == SOURCE_NOT_INITIALIZED) {
            readLine();
            return nextChar();
        }

        if(line == null) {
            return EOF;
        }

        if(currentPos == LINE_NOT_INITIALIZED || currentPos == line.length()) {
            return EOL;
        }

        if(currentPos > line.length()) {
            readLine();
            return nextChar();
        }

        return line.charAt(currentPos);
    }

    public char nextChar() throws IOException {
        ++currentPos;
        return currentChar();
    }

    public char peekChar() throws IOException {
        currentChar();

        if(line == null) {
            return EOF;
        }

        int next = currentPos + 1;
        return next < line.length() ? line.charAt(next) : EOL;
    }

    private void readLine() throws IOException {
        line = reader.readLine();
        currentPos = LINE_NOT_INITIALIZED;

        if(line != null) {
            ++lineNum;
        }

        if(line != null) {
            sendMessage(new Message(SOURCE_LINE, new Object[]{lineNum, line}));
        }
    }

    public void close() throws IOException {
        if(reader != null) {
            try {
                reader.close();
            } catch(IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }

    public void addMessageListener(MessageListener messageListener) {
        messageHandler.addListener(messageListener);
    }

    public void removeMessageListener(MessageListener messageListener) {
        messageHandler.removeListener(messageListener);
    }
}
