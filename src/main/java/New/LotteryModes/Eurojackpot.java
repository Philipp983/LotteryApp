package New.LotteryModes;

import New.AbstractClass.LotteryGame;
import New.Messages.Messages;
import New.Utility.LogFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Eurojackpot extends LotteryGame {


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
            int euroNumber = random.nextInt(12) + 1;
            if (!euroNumbers.contains(euroNumber)
                && (!unluckyNumbers.contains(euroNumber))) {
                euroNumbers.add(euroNumber);
            }
        }

        Collections.sort(randomNumbers);
        LogFiles.getInstance().addToLogs(randomNumbers + " are the generated and sorted 5aus50 numbers");
        Collections.sort(euroNumbers);
        LogFiles.getInstance().addToLogs(euroNumbers + " are the generated and sorted 2aus12 numbers");

        // Combine main numbers and Euro numbers into one list
        List<Integer> combinedNumbers = new ArrayList<>(randomNumbers);
        combinedNumbers.addAll(euroNumbers);


        LogFiles.getInstance().addToLogs("Returning random numbers");
        return combinedNumbers;
    }

    @Override
    public void newUnluckyNumbers() {

    }

    @Override
    public void deleteUnluckyNumbers() {

    }

    @Override
    public void showUnluckyNumbers() {

    }

    @Override
    public void loadUnluckyNumbers() {
        for (int num : unluckyNumbers) {
            if (num < 1 || num > 50) {
                System.out.println(Messages.LOADED_NUMBER_OUT_OF_RANGE2);
                System.exit(0);
            }
        }
    }
}
