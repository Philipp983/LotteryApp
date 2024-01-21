package New.Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The LogFiles class is a singleton that manages logging operations for the application.
 * It provides functionalities to add log entries, and write them to a file on the user's desktop.
 */
public class LogFiles {

    private static LogFiles instance;
    public List<String> logs = new ArrayList<>();

    private LogFiles() {}

    /**
     * Retrieves the singleton instance of LogFiles. If it doesn't exist, it's created.
     *
     * @return The singleton instance of LogFiles.
     */
    public static synchronized LogFiles getInstance() {
        if (instance == null) {
            instance = new LogFiles();
        }
        return instance;
    }

    /**
     * Adds a new log entry to the logs list.
     *
     * @param log The log message to be added.
     */
    public void addToLogs(String log) {
        logs.add(log);
    }

    /**
     * Writes all the log entries from the logs list to a file named "logs.txt" on the user's desktop.
     * If the file already exists, it is deleted and created anew before writing the logs.
     */
    public void write() {
        String desktopPath = System.getProperty("user.home") + "/Desktop";

        String fileName = "logs.txt";
        Path filePath = Paths.get(desktopPath, fileName);

        try {
            if (Files.exists(filePath)) {

                Files.deleteIfExists(filePath);
            }
            Files.createDirectories(filePath.getParent());
            Files.createFile(filePath);

            Files.write(filePath, this.logs);

        } catch (IOException e) {
        }
    }
}
