package GameModes;

import Interface.LotteryType;

import java.util.*;

/**
 * The Lottery class for playing 6 out of 49. Currently only implements generating random numbers.
 */

public class Lottery implements LotteryType {
    private List<Integer> unluckyNumbers;

    // Constructor with hard coded list of unlucky numbers, to see if the generating works and doesn't include these unlucky numbers.
    public Lottery() {
        this.unluckyNumbers = Arrays.asList(1, 20, 44);
    }

    public List<Integer> generateRandomNumbers() {

        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        int randomNumber;

        while (randomNumbers.size()!= 6) {

            randomNumber = random.nextInt(49) + 1;

            if (!randomNumbers.contains(randomNumber)
                    && (unluckyNumbers == null ||!unluckyNumbers.contains(randomNumber))) {
                randomNumbers.add(randomNumber);
            }
        }
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

}
