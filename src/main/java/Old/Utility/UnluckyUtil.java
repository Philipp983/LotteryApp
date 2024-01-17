package Old.Utility;

import java.util.List;

public class UnluckyUtil {

    private static List<Integer> unluckyNumbers = FileUtil.readFromFile();

    private UnluckyUtil() {}

    public static List<Integer> getUnluckyNumbers() {
        if (unluckyNumbers == null) {
            unluckyNumbers = FileUtil.readFromFile();
        }
        return unluckyNumbers;
    }

    public static void setUnluckyNumbers(List<Integer> newUnluckyNumbers) {
        unluckyNumbers = newUnluckyNumbers;
    }

    public static void displayUnluckyNumbers() {
        if (unluckyNumbers != null && !unluckyNumbers.isEmpty()) {
            System.out.println("Unlucky Numbers: " + unluckyNumbers);
        } else {
            System.out.println("No unlucky numbers set.");
        }
    }

    public static void clearUnluckyNumbers() {
        FileUtil.clearFile();
        unluckyNumbers.clear();
        System.out.println("Unlucky numbers cleared.");
    }

}
