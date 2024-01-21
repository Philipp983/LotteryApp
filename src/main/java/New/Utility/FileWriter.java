package New.Utility;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileWriter class handles file operations related to writing and reading
 * unlucky numbers to and from a file. It includes functionality to write a string
 * to a file, read numbers from a file, and clear the file content.
 */
public class FileWriter {

    /**
     * Writes a string of numbers to a file named "unlucky_numbers.txt" on the user's desktop.
     * If the file exists, it is deleted and created anew before writing.
     *
     * @param numbers The string to be written to the file.
     */
    public static void write(String numbers) {
        String desktopPath = System.getProperty("user.home") + "/Desktop";

        String fileName = "unlucky_numbers.txt";
        Path filePath = Paths.get(desktopPath,fileName);

        try {
            if (Files.exists(filePath)) {
                Files.deleteIfExists(filePath);
            }
            Files.createDirectories(filePath.getParent());
            Files.createFile(filePath);

            Files.write(filePath, numbers.getBytes());

        } catch (IOException e) {
        }
    }

    /**
     * Reads numbers from the "unlucky_numbers.txt" file on the user's desktop.
     * If the file does not exist, it is created. The method parses the file content
     * into integers and adds them to a list.
     *
     * @return A list of integers read from the file.
     */

    public static List<Integer> read() {
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String fileName = "unlucky_numbers.txt";
        Path filePath = Paths.get(desktopPath, fileName);
        List<Integer> numbers = new ArrayList<>();

        try {
            if (!Files.exists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
                LogFiles.getInstance().addToLogs("New File unlucky-numbers.txt created");
                //System.out.println(Messages.FILE_CREATED);
            }
            String fileContent = new String(Files.readAllBytes(filePath));

            // Check if file content is not empty
            if (!fileContent.isEmpty()) {
                // Remove square brackets and split on commas
                fileContent = fileContent.replaceAll("[\\[\\]]", "").trim();
                String[] numberStrings = fileContent.split(",");

                for (String numberStr : numberStrings) {
                    try {
                        numbers.add(Integer.parseInt(numberStr.trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format: " + numberStr);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        LogFiles.getInstance().addToLogs("Read out unlucky numbers from unlucky-numbers.txt are " + numbers);
        return numbers;
    }

    /**
     * Clears the content of the "unlucky_numbers.txt" file on the user's desktop.
     * If the file exists, its content is erased.
     */
    public static void clearFile() {
        String desktopPath = System.getProperty("user.home") + "/Desktop";

        String fileName = "unlucky_numbers.txt";
        Path filePath = Paths.get(desktopPath, fileName);

        try {
            if (Files.exists(filePath)) {
                //Files.deleteIfExists(filePath);
                Files.write(filePath, new byte[0]);
            }
        } catch (IOException e) {

        }
    }

}
