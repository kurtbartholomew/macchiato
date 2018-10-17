package frontend;

import intermediate.ICode;
import intermediate.SymTab;

/**
 * Syntactically analyzes tokens from scanner and creates
 * Intermediate Representation code (IR)
 */
public abstract class Parser {

    protected Scanner scanner;
    protected ICode iCode;
    protected static SymTab symTab = null;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
        this.iCode = null;
    }

    public abstract void parse() throws Exception;

    public abstract int getErrorCount();


    public Token currentToken() {
        return scanner.currentToken();
    }

    public Token nextToken() throws Exception {
        return scanner.nextToken();
    }
}
