package Utility;

import java.util.ArrayList;
import java.util.List;

public class UnluckyUtil {

    private static List<Integer> unluckyNumbers = new ArrayList<>();

    private UnluckyUtil() {}

    public static List<Integer> getUnluckyNumbers() {
        return unluckyNumbers;
    }

    public static void setUnluckyNumbers(List<Integer> newUnluckyNumbers) {
        unluckyNumbers = newUnluckyNumbers;
    }

}
