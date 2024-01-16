package GameModes;

import Interface.LotteryType;
import Messages.Messages;
import Utility.UnluckyUtil;

import java.util.*;

/**
 * The Lottery class for playing 6 out of 49. Currently only implements generating random numbers.
 */

public class Lottery implements LotteryType {
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
        List<Integer> unluckyLottoNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + Messages.ENTERING_UNLUCKY_NUMBERS);

        while (unluckyLottoNumbers.size() < 6) {
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                break;
            }

            try {
                int number = Integer.parseInt(input);

                if (unluckyLottoNumbers.contains(number)) {
                    System.out.println(Messages.ALREADY_EXISTS_UNLUCKY_NUMBER);
                } else if (number >= 1 && number <= 49) {
                    unluckyLottoNumbers.add(number);
                } else {
                    System.out.println(Messages.INVALID_UNLUCKY_NUMBER);
                }
            } catch (NumberFormatException e) {
                System.out.println(Messages.INVALID_UNLUCKY_NUMBER);
            }
        }
        //Save the unlucky numbers in the Util class
        UnluckyUtil.setUnluckyNumbers(unluckyLottoNumbers);
    }

}
