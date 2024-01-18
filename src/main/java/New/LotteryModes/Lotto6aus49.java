package New.LotteryModes;

import New.AbstractClass.LotteryGame;
import New.Messages.Messages;
import New.Utility.LogFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto6aus49 extends LotteryGame {

    //private static LogFiles logFiles = new LogFiles();


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
            if (num < 1 || num > 49) {
                System.out.println(Messages.LOADED_NUMBER_OUT_OF_RANGE1);
                System.exit(0);
            }
        }
    }
}
