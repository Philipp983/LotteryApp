package New.Utility;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileWriterTest {

    private static final String TEST_FILE_NAME = "unlucky_numbers_test.txt";
    private static final Path TEST_FILE_PATH = Paths.get(System.getProperty("user.home") + "/Desktop", TEST_FILE_NAME);

    @BeforeEach
    void setUp() {
        try {
            Files.createFile(TEST_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(TEST_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testWriteAndRead() {
        String numbersToWrite = "1, 2, 3, 4, 5";
        FileWriter.write(numbersToWrite);

        List<Integer> readNumbers = FileWriter.read();

        assertEquals(List.of(1, 2, 3, 4, 5), readNumbers);
    }

    @Test
    void testClearFile() {
        String numbersToWrite = "1, 2, 3, 4, 5";
        FileWriter.write(numbersToWrite);

        FileWriter.clearFile();

        List<Integer> readNumbers = FileWriter.read();

        assertTrue(readNumbers.isEmpty());
    }

    @Test
    void testReadEmptyFile() {

        FileWriter.clearFile();

        List<Integer> readNumbers = FileWriter.read();

        assertTrue(readNumbers.isEmpty());
    }
}
