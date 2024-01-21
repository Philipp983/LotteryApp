package New.Utility;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The LotteryTicketOutputFormatter class is responsible for formatting and displaying
 * lottery numbers for different lottery games. It provides methods to format numbers
 * for the 6aus49 and Eurojackpot games.
 */
public class LotteryTicketOutputFormatter {

    /**
     * Formats and prints the output for the 6aus49 lottery game.
     * Takes a list of random numbers and displays them in a comma-separated format.
     *
     * @param randomNumbers List of integers representing the randomly generated numbers for 6aus49.
     */
    public static void modify6aus49Output(List<Integer> randomNumbers) {
        // Formatting the output
        System.out.println("\n6aus49 Tippzahlen: " + randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    /**
     * Formats and prints the output for the Eurojackpot lottery game.
     * Separates the list into two parts: 5aus50 and 2aus12, and displays them in a comma-separated format.
     *
     * @param randomNumbers List of integers representing the randomly generated numbers for Eurojackpot.
     */
    public static void modifyEurojackpotOutput(List<Integer> randomNumbers) {
        List<Integer> numbers5aus50 = randomNumbers.subList(0, 5);
        List<Integer> numbers2aus12 = randomNumbers.subList(5, 7);

        // Formatting the output
        System.out.println("\nEurojackpot 5aus50: " + numbers5aus50.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println("2aus10: " + numbers2aus12.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
