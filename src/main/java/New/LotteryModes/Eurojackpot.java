package New.LotteryModes;

import New.AbstractClass.LotteryGame;
import New.Messages.Messages;
import New.Utility.LogFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The Eurojackpot class extends LotteryGame to implement the functionality specific to the Eurojackpot lottery.
 * It includes methods to generate random lottery numbers while excluding unlucky numbers,
 * load unlucky numbers with range validation, and set unlucky numbers for the game.
 */
public class Eurojackpot extends LotteryGame {


    /**
     * Generates a combination of random numbers for the Eurojackpot lottery.
     * The method creates 5 main numbers (from 1 to 50) and 2 Euro numbers (from 1 to 10),
     * without unlucky numbers.
     *
     * @param unluckyNumbers List of numbers to be excluded from the random generation.
     * @return A combined list of 5 main numbers and 2 Euro numbers for the Eurojackpot lottery.
     */
    @Override
    public List<Integer> generateRandomNumbers(List<Integer> unluckyNumbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        while (randomNumbers.size() < 5) {
            int number = random.nextInt(50) + 1;
            if (!randomNumbers.contains(number)
                && (!unluckyNumbers.contains(number))) {
                randomNumbers.add(number);
            }
        }

        List<Integer> euroNumbers = new ArrayList<>();
        while (euroNumbers.size() < 2) {
            int euroNumber = random.nextInt(10) + 1;
            if (!euroNumbers.contains(euroNumber)
                && (!unluckyNumbers.contains(euroNumber))) {
                euroNumbers.add(euroNumber);
            }
        }

        Collections.sort(randomNumbers);
        LogFiles.getInstance().addToLogs(randomNumbers + " are the generated and sorted 5aus50 numbers");
        Collections.sort(euroNumbers);
        LogFiles.getInstance().addToLogs(euroNumbers + " are the generated and sorted 2aus10 numbers");

        // Combine main numbers and Euro numbers into one list
        List<Integer> combinedNumbers = new ArrayList<>(randomNumbers);
        combinedNumbers.addAll(euroNumbers);


        LogFiles.getInstance().addToLogs("Returning random numbers");
        return combinedNumbers;
    }


    /**
     * Loads and validates unlucky numbers for the Eurojackpot game.
     * This method checks if the unlucky numbers are within the valid range (1 to 50).
     * If any number is out of range, it throws an IllegalArgumentException.
     */
    @Override
    public void loadUnluckyNumbers() {
        for (int num : unluckyNumbers) {
            if (num < 1 || num > 50) {
                System.out.println(Messages.LOADED_NUMBER_OUT_OF_RANGE2);
                LogFiles.getInstance().addToLogs(Messages.LOADED_NUMBER_OUT_OF_RANGE2);
                LogFiles.getInstance().addToLogs("End of application");
                LogFiles.getInstance().write();
                throw new IllegalArgumentException(Messages.LOADED_NUMBER_OUT_OF_RANGE2);
            }
        }
    }

    /**
     * Sets unlucky numbers for the Eurojackpot game.
     * This method overrides the setUnluckyNumbers method from the LotteryGame abstract class.
     *
     * @param unluckyNumbers List of numbers to set as unlucky for the Eurojackpot game.
     */
    @Override
    public void setUnluckyNumbers(List<Integer> unluckyNumbers) {
        super.setUnluckyNumbers(unluckyNumbers);
    }
}
