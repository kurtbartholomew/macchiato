package frontend;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class SourceTest {

    public static final String TEST_FILE = "testFile.txt";

    BufferedReader reader;
    Source source;

    @Rule
    public final ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            Path filePath = Paths.get("src","test","resources",TEST_FILE);
            reader = new BufferedReader(new FileReader(filePath.toFile()));
            source = new Source(reader);
        }

        @Override
        protected void after() {
            try {
                reader.close();
            } catch(IOException e) {}
        }
    };

    @Test
    public void currentCharShouldReturnTheFirstCharacterInFile() {

        char c = ' ';
        try {
            c = source.currentChar();
        } catch(IOException e) { }
        assertEquals('T', c);
    }

    @Test
    public void currentCharShouldReturnEndOfLine() {
        char c = ' ';
        try {
            source.currentChar();
            source.nextChar();
            c = source.currentChar();
        } catch(IOException e) { }
        assertEquals(source.EOL, c);

    }

    @Test
    public void currentCharShouldReturnEndOfFile() {
        char c = ' ';
        try {
            source.currentChar();
            source.nextChar();
            source.nextChar();
            source.nextChar();
            source.nextChar();
            c = source.currentChar();
        } catch(IOException e) { }
        assertEquals(source.EOF, c);
    }

    @Test
    public void currentCharShouldReturnCharacterAtStartOfNextLine() {
        char c = ' ';
        try {
            source.currentChar();
            source.nextChar();
            source.nextChar();
            c = source.currentChar();
        } catch(IOException e) { }
        assertEquals('B', c);
    }

    @Test
    public void nextCharReturnsNextCharacter() {
        char c = ' ';
        try {
            source.currentChar();
            c = source.nextChar();
        } catch(IOException e) {}
        assertEquals(source.EOL, c);
    }

    @Test
    public void peekCharShouldReturnTheNextCharacterWithoutChangingCurrent() {
        char n = ' ';
        char c = ' ';
        try {
            source.currentChar();
            n = source.peekChar();
            c = source.currentChar();
        } catch(IOException e) {}
        assertEquals(source.EOL, n);
        assertEquals('T', c);
    }

    @Test
    public void peekCharShouldReturnEOFIfAtEndOfFile() {
        char n = ' ';
        try {
            source.currentChar();
            source.nextChar();
            source.nextChar();
            source.nextChar();
            source.nextChar();
            n = source.peekChar();
        } catch (IOException e) {
        }
        assertEquals(source.EOF, n);
    }
}