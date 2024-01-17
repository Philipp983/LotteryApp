package New.Utility;

import New.AbstractClass.LotteryGame;
import New.LotteryModes.Eurojackpot;
import New.LotteryModes.Lotto6aus49;
import New.Messages.Messages;
import java.util.List;
import java.util.Scanner;

public class UnlimitedLottoGenerator implements Runnable {

    private volatile boolean running = true;
    private List<Integer> unluckyNumbers;
    private LotteryGame lotteryGame;

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

    @Override
    public void run() {
        int index = 1;
        while (running) {
            List<Integer> numbers = lotteryGame.generateRandomNumbers(unluckyNumbers);
            System.out.println("Tippschein Nummer " + index + ": " + numbers);
            index++;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
        }
    }

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

    public void stopGenerating() {
        running = false;
        System.out.println(Messages.CLOSING);
    }
}
