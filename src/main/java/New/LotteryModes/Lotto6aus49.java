package New.LotteryModes;

import New.AbstractClass.LotteryGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto6aus49 extends LotteryGame {


    @Override
    public List<Integer> generateRandomNumbers(String[] args) {

        List<Integer> randomNumbers = new ArrayList<>();

        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                try {
                    unluckyNumbers.add(Integer.parseInt(args[i]));
                } catch (NumberFormatException e) {
                    System.err.println("Es müssen Zahlen eingegeben werden statt: " + args[i]);
                }
            }

        }

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
}
