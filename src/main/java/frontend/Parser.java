package frontend;

import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;
import java.io.*;

/**
 * Syntactically analyzes tokens from scanner and creates
 * Intermediate Representation code (IR)
 */
public abstract class Parser implements MessageProducer {

    protected Scanner scanner;
    protected ICode iCode;
    protected static SymTab symTab = null;
    protected static MessageHandler messageHandler = new MessageHandler();

    public Parser(Scanner scanner) {
        this.scanner = scanner;
        this.iCode = null;
    }

    public abstract void parse() throws IOException;

    public abstract int getErrorCount();


    public Token currentToken() {
        return scanner.currentToken();
    }

    public Token nextToken() throws IOException {
        return scanner.nextToken();
    }

    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
