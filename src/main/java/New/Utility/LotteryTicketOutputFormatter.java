package New.Utility;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicketOutputFormatter {

    public static void modify6aus49Output(List<Integer> randomNumbers) {
        // Formatting the output
        System.out.println("\n6aus49 Tippzahlen: " + randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    public static void modifyEurojackpotOutput(List<Integer> randomNumbers) {
        List<Integer> numbers5aus50 = randomNumbers.subList(0, 5);
        List<Integer> numbers2aus12 = randomNumbers.subList(5, 7);

        // Formatting the output
        System.out.println("\nEurojackpot 5aus50: " + numbers5aus50.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println("2aus12: " + numbers2aus12.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
