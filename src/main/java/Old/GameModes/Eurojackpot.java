package Old.GameModes;

import Old.Interface.LotteryType;
import Old.Utility.UnluckyUtil;

import java.util.*;

/**
 * The EurojackpotLottery class for playing Eurojackpot. Currently only implements generating random numbers.
 */
public class Eurojackpot implements LotteryType {

    @Override
    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        while (randomNumbers.size() < 5) {
            int number = random.nextInt(50) + 1;
            if (!randomNumbers.contains(number)
                    && (!UnluckyUtil.getUnluckyNumbers().contains(number))) {
                randomNumbers.add(number);
            }
        }

        List<Integer> euroNumbers = new ArrayList<>();
        while (euroNumbers.size() < 2) {
            int euroNumber = random.nextInt(12) + 1;
            if (!euroNumbers.contains(euroNumber)
                    && (!UnluckyUtil.getUnluckyNumbers().contains(euroNumber))) {
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

    @Override
    public void newUnluckyNumbers() {
    }
}
