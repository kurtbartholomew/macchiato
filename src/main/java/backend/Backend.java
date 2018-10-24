package backend;

import message.*;

import java.io.IOException;

public abstract class Backend implements MessageProducer {
    protected static MessageHandler messageHandler = new MessageHandler();

    protected SymTab symTab;
    protected ICode iCode;

    public abstract void process(ICode iCode, SymTab symTab) throws IOException;
}
