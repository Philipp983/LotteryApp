package Utility;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String strName = "unluckyNumbers";


        public static void newFile() {

            try {
                // Creating File Object
                File file1 = new File(strName + ".txt");

                // Method createNewFile() method creates blank
                // file.
                file1.createNewFile();
            }

            // Try-Catch Block
            catch (Exception ex1) {
            }
        }

        public static void writeToFile (List<Integer> numbers) {
            newFile(); // Create the file if it doesn't exist

            try {
                FileWriter fw = new FileWriter(strName + ".txt");
                BufferedWriter bw = new BufferedWriter(fw);

                for (int number : numbers) {
                    bw.write(number + "\n");
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public static void clearFile() {

            newFile();

            try {
                FileWriter fw = new FileWriter(strName + ".txt", false);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    public static List<Integer> readFromFile() {
        List<Integer> numbers = new ArrayList<>();
        File file = new File(strName + ".txt");

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    try {
                        numbers.add(Integer.parseInt(line.trim()));
                    } catch (NumberFormatException e) {
                    }
                }

                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return numbers;
    }

}

