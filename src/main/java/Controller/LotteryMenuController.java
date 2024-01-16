package Controller;

import GameModes.Eurojackpot;
import GameModes.Lottery;
import Interface.LotteryType;
import Messages.Messages;
import Utility.UnluckyUtil;

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
        String promptForGameMode;
        while (true) {
            System.out.println(Messages.START_COMMAND);
            promptForGameMode = input.nextLine().trim();

            if (promptForGameMode.equalsIgnoreCase("6aus49") || promptForGameMode.isEmpty()) {
                if (playLotteryGame(lottery)) {
                    break;
                }
            } else if (promptForGameMode.equalsIgnoreCase("Eurojackpot")) {
                if (playLotteryGame(eurojackpot)) {
                    break;
                }
            } else if (promptForGameMode.equalsIgnoreCase("Exit")) {
                System.out.println(Messages.END_COMMAND);
                System.exit(0);
            } else {
                System.out.println(Messages.WRONG_PROMPT);
            }
        }
    }

    private boolean playLotteryGame(LotteryType lotteryGame) {
        while (true) {
            System.out.println(Messages.ACTION_COMMAND);
            String selection = input.nextLine();

            switch (selection) {
                case "1":
                    System.out.println("\nNumbers: " + lotteryGame.generateRandomNumbers());
                    break;
                case "2":
                    System.out.println(Messages.END_COMMAND);
                    return true;
                case "3":
                    return false;
                case "4":
                    lotteryGame.newUnluckyNumbers();
                    continue;
                case "5":
                    UnluckyUtil.displayUnluckyNumbers();
                    continue;
                default:
                    break;
            }
        }
    }

}
