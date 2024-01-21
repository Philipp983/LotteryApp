package New.LotteryModes;

import New.AbstractClass.LotteryGame;
import New.Messages.Messages;
import New.Utility.LogFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The Lotto6aus49 class extends LotteryGame to implement the specific functionality
 * for the Lotto 6 aus 49 lottery game. This class is responsible for generating lottery
 * numbers, considering unlucky numbers, and ensuring that the generated numbers are within
 * the game's valid range.
 */
public class Lotto6aus49 extends LotteryGame {
    /**
     * Generates a set of random numbers for the Lotto 6 aus 49 game.
     * It creates 6 unique random numbers, each between 1 and 49, without any unlucky numbers. The generated numbers are sorted before
     * being returned.
     *
     * @param unluckyNumbers List of numbers to be excluded from the random generation.
     * @return A list of 6 sorted random numbers for the Lotto 6 aus 49 game.
     */
    @Override
    public List<Integer> generateRandomNumbers(List<Integer> unluckyNumbers) {

        List<Integer> randomNumbers = new ArrayList<>();

        Random random = new Random();
        int randomNumber;

        while (randomNumbers.size()!= 6) {

            randomNumber = random.nextInt(49) + 1;

            if (!randomNumbers.contains(randomNumber)
                    && (!unluckyNumbers.contains(randomNumber))) { //Compare the random numbers to the numbers from the Util class
                randomNumbers.add(randomNumber);
            }
        }
        Collections.sort(randomNumbers);
        LogFiles.getInstance().addToLogs(randomNumbers + " are the generated and sorted lottery numbers");
        LogFiles.getInstance().addToLogs("Returning random numbers");

        return randomNumbers;
    }

    /**
     * Loads and validates the unlucky numbers for the Lotto 6 aus 49 game.
     * Checks if the unlucky numbers are within the valid range (1 to 49).
     * If any number is out of range, it throws an IllegalArgumentException.
     */
    @Override
    public void loadUnluckyNumbers() {
        for (int num : unluckyNumbers) {
            if (num < 1 || num > 49) {
                System.out.println(Messages.LOADED_NUMBER_OUT_OF_RANGE1);
                LogFiles.getInstance().addToLogs(Messages.LOADED_NUMBER_OUT_OF_RANGE1);
                LogFiles.getInstance().addToLogs("End of application");
                LogFiles.getInstance().write();
                throw new IllegalArgumentException(Messages.LOADED_NUMBER_OUT_OF_RANGE1);
            }
        }
    }


    /**
     * Sets the unlucky numbers for the Lotto 6 aus 49 game.
     * Overrides the setUnluckyNumbers method from the LotteryGame abstract class to
     * apply specific validation or processing for the Lotto 6 aus 49 game.
     *
     * @param unluckyNumbers List of numbers to set as unlucky for the Lotto 6 aus 49 game.
     */
    public void setUnluckyNumbers(List<Integer> unluckyNumbers) {
        super.setUnluckyNumbers(unluckyNumbers);
    }


}
