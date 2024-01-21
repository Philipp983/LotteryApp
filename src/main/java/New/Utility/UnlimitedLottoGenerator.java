package New.Utility;

import New.AbstractClass.LotteryGame;
import New.LotteryModes.Eurojackpot;
import New.LotteryModes.Lotto6aus49;
import New.Messages.Messages;
import java.util.List;
import java.util.Scanner;

/**
 * The UnlimitedLottoGenerator class implements Runnable and is designed to continuously generate
 * lottery numbers for specified lottery games until stopped. It supports different types of lottery games
 * like 6aus49 and Eurojackpot and allows the exclusion of unlucky numbers.
 */
public class UnlimitedLottoGenerator implements Runnable {

    private volatile boolean running = true;
    private List<Integer> unluckyNumbers;
    private LotteryGame lotteryGame;

    /**
     * Constructor to initialize the UnlimitedLottoGenerator with a specific game type and unlucky numbers.
     *
     * @param gameType The type of lottery game ("6aus49" or "Eurojackpot").
     * @param unluckyNumbers A list of numbers to be excluded when generating lottery numbers.
     */
    public UnlimitedLottoGenerator(String gameType, List<Integer> unluckyNumbers) {
        this.unluckyNumbers = unluckyNumbers;
        switch (gameType) {
            case "6aus49":
                this.lotteryGame = new Lotto6aus49();
                break;
            case "Eurojackpot":
                this.lotteryGame = new Eurojackpot();
                break;
            default:
                throw new IllegalArgumentException(Messages.COMMAND_LIST);
        }
    }

    /**
     * The run method continuously generates lottery numbers based on the specified game type.
     * It runs in a loop until the 'running' flag is set to false.
     */
    @Override
    public void run() {
        int index = 1;
        while (running) {
            List<Integer> numbers = lotteryGame.generateRandomNumbers(unluckyNumbers);

            if (lotteryGame instanceof Lotto6aus49) {
                System.out.print("Tippschein Nummer " + index + ": ");
                LotteryTicketOutputFormatter.modify6aus49Output(numbers);
                LogFiles.getInstance().addToLogs("Lottery ticket number " + index + " with numbers: " + numbers);
            } else if (lotteryGame instanceof Eurojackpot) {
                System.out.print("Tippschein Nummer " + index + ": ");
                LotteryTicketOutputFormatter.modifyEurojackpotOutput(numbers);
                LogFiles.getInstance().addToLogs("Lottery ticket number " + index + " with numbers: " + numbers);
            }

            index++;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * Starts the lottery number generation in a separate thread.
     * Waits for user input to stop the generation.
     */
    public void startGenerating() {
        Thread generatorThread = new Thread(this);
        generatorThread.start();
        System.out.println(Messages.ANY_KEY_COMMAND);

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        stopGenerating();

        generatorThread.interrupt();
        try {
            generatorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stops the lottery number generation by setting the 'running' flag to false.
     * Also logs the stopping action and writes logs to the file.
     */
    public void stopGenerating() {
        running = false;
        System.out.println(Messages.CLOSING);
        LogFiles.getInstance().addToLogs("Stopped generating lottery ticket");
        LogFiles.getInstance().addToLogs("End of application");
        LogFiles.getInstance().write();

    }
}
