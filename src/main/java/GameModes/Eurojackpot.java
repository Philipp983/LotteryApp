package GameModes;

import Interface.LotteryType;

import java.util.*;

/**
 * The EurojackpotLottery class for playing Eurojackpot. Currently only implements generating random numbers.
 */
public class Eurojackpot implements LotteryType {
    private List<Integer> unluckyNumbers;

    public Eurojackpot() {
        this.unluckyNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Override
    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        while (randomNumbers.size() < 5) {
            int number = random.nextInt(50) + 1;
            if (!randomNumbers.contains(number)
                    && (unluckyNumbers == null || !unluckyNumbers.contains(number))) {
                randomNumbers.add(number);
            }
        }

        List<Integer> euroNumbers = new ArrayList<>();
        while (euroNumbers.size() < 2) {
            int euroNumber = random.nextInt(12) + 1;
            if (!euroNumbers.contains(euroNumber)
                    && (unluckyNumbers == null || !unluckyNumbers.contains(euroNumber))) {
                euroNumbers.add(euroNumber);
            }
        }

        Collections.sort(randomNumbers);
        Collections.sort(euroNumbers);

        // Combine main numbers and Euro numbers into one list
        List<Integer> combinedNumbers = new ArrayList<>(randomNumbers);
        combinedNumbers.addAll(euroNumbers);

        return combinedNumbers;
    }
}
