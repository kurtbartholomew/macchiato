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

    @Rule
    public final ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            Path filePath = Paths.get("src","test","resources",TEST_FILE);
            reader = new BufferedReader(new FileReader(filePath.toFile()));
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

    }

    @Test
    public void currentCharShouldReturnEndOfFile() {

    }

    @Test
    public void currentCharShouldReturnEndOfLine() {

    }

    @Test
    public void currentCharShouldReturnCharacterAtStartOfNextLine() {

    }

    @Test
    public void currentCharShouldReturnCurrentCharacter() {

    }


    @Test
    public void nextChar() {
    }

    @Test
    public void peekChar() {
    }

    @Test
    public void close() {
    }
}