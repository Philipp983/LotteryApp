package New.Utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LogFilesTest {

    private static final String TEST_FILE_NAME = "logs_test.txt";
    private static final Path TEST_FILE_PATH = Paths.get(System.getProperty("user.home") + "/Desktop", TEST_FILE_NAME);

    @BeforeEach
    void setUp() {
        LogFiles.getInstance().logs.clear();
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
    void testAddToLogs() {
        LogFiles logFiles = LogFiles.getInstance();
        logFiles.addToLogs("Log entry 1");
        logFiles.addToLogs("Log entry 2");

        List<String> logs = logFiles.logs;
        assertEquals(List.of("Log entry 1", "Log entry 2"), logs);
    }

    @Test
    void testWrite() {
        LogFiles logFiles = LogFiles.getInstance();
        logFiles.addToLogs("Log entry 1");
        logFiles.addToLogs("Log entry 2");

        logFiles.write();

        List<String> readLogs = readTestFileContent();
        readLogs.add("Log entry 1");
        readLogs.add("Log entry 2");

        assertEquals(List.of("Log entry 1", "Log entry 2"), readLogs);
    }

    private List<String> readTestFileContent() {
        try {
            return Files.readAllLines(TEST_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
