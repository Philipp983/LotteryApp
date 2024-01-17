package New.LotteryModes;

import New.AbstractClass.LotteryGame;
import Old.Utility.UnluckyUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto6aus49 extends LotteryGame {


    @Override
    public List<Integer> generateRandomNumbers() {

        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        int randomNumber;

        while (randomNumbers.size()!= 6) {

            randomNumber = random.nextInt(49) + 1;

            if (!randomNumbers.contains(randomNumber)
                    && (!UnluckyUtil.getUnluckyNumbers().contains(randomNumber))) { //Compare the random numbers to the numbers from the Util class
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
