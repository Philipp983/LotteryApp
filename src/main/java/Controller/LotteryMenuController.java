package Controller;

import GameModes.Eurojackpot;
import GameModes.Lottery;
import Interface.LotteryType;
import Messages.Messages;

import java.util.Scanner;

/**
 * Class that handles the main menu of the program. Currently two methods are implemented:
 * display Main Menu and play Lottery Game.
 * display Main Menu is called at the start of the program, and shows the user the options to play the lottery.
 * playLotteryGame then calls the respective function to (currently) generate random numbers and play the lottery game.
 */

public class LotteryMenuController {

    private final Scanner input = new Scanner(System.in);
    private final Lottery lottery = new Lottery();
    private final Eurojackpot eurojackpot = new Eurojackpot();

    public void displayMainMenu() {
        String numberSelection;
        do {
            System.out.println(Messages.START_COMMAND);
            numberSelection = input.nextLine();
        } while (!numberSelection.isEmpty() && !numberSelection.equals("1") && !numberSelection.equals("2") && !numberSelection.equals("3"));

        switch (numberSelection) {
            case "1":
                playLotteryGame(lottery);
                break;
            case "2":
                playLotteryGame(eurojackpot);
                break;
            case "3":
                System.out.println(Messages.END_COMMAND);
                System.exit(0);
                break;
//            default:
//                break;
        }
    }

    private void playLotteryGame(LotteryType lotteryGame) {
        while (true) {
            System.out.println(Messages.ACTION_COMMAND);
            String selection = input.next();

            switch (selection) {
                case "1":
                    System.out.println("\nNumbers: " + lotteryGame.generateRandomNumbers());
                    break;
                case "2":
                    System.out.println(Messages.END_COMMAND);
                    return;
                default:
                    break;
            }
        }
    }

}
