package New.Utility;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {

    public void write(String numbers) {
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

//    public static String read() {
//        String desktopPath = System.getProperty("user.home") + "/Desktop";
//
//        String fileName = "unlucky_numbers.txt";
//        Path filePath = Paths.get(desktopPath,fileName);
//
//        try {
//            byte[] fileContent = Files.readAllBytes(filePath);
//            return new String(fileContent);
//
//        } catch (IOException e) {
//            return "";
//        }
//    }

    public static List<Integer> read2() {
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String fileName = "unlucky_numbers.txt";
        Path filePath = Paths.get(desktopPath, fileName);
        List<Integer> numbers = new ArrayList<>();

        try {
            String fileContent = new String(Files.readAllBytes(filePath));
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
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return numbers;
    }

    public void delete() {
        String desktopPath = System.getProperty("user.home") + "/Desktop";

        String fileName = "unlucky_numbers.txt";
        Path filePath = Paths.get(desktopPath, fileName);

        try {
            if (Files.exists(filePath)) {
                Files.deleteIfExists(filePath);
            }
        } catch (IOException e) {

        }
    }

}
