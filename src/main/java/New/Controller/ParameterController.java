package New.Controller;

import New.AbstractClass.LotteryGame;
import New.LotteryModes.Eurojackpot;
import New.LotteryModes.Lotto6aus49;
import New.Messages.Messages;
import New.Utility.FileWriter;

import java.util.ArrayList;
import java.util.List;

public class ParameterController {

    private final List<Integer> processedArgs = new ArrayList<>();

    public void processCommands(String[] args) {

        FileWriter fileWriter = new FileWriter();

        String firstCommand = args.length > 0 ? args[0] : "6aus49";

        if ((args[0].equals("6aus49") || args[0].equals("Eurojackpot")
             || args[0].equals("setunluckynumbers")) && args.length > 1) {
            extractedUnluckyNumbers(args);
            fileWriter.write(processedArgs.toString());

        } else if ((args[0].equals("6aus49") || args[0].equals("Eurojackpot"))
                   && args.length == 1) {

            LotteryGame lotteryGame;
            switch (args[0]) {
                case "6aus49":
                    lotteryGame = new Lotto6aus49();
                    break;
                case "Eurojackpot":
                    lotteryGame = new Eurojackpot();
                    break;
                default:
                    return;
            }
            lotteryGame.loadUnluckyNumbers();
            //lotteryGame.printUnluckyNumbers();

        }

        switch (firstCommand) {
            case "6aus49":
                process6aus49(processedArgs);
                break;
            case "Eurojackpot":
                processEurojackpot(processedArgs);
                break;
            case "setunluckynumbers":
                if (args.length == 1) {
                    System.out.println(Messages.NO_NEW_NUMBERS_PASSED);
                } else {
                    System.out.println(Messages.NEW_NUMBERS);
                }
                break;
            case "deleteunluckynumbers":
                deleteUnluckyNumbers();
                break;
            case "showunluckynumbers":
                showUnluckyNumbers();
                break;
            default:
                System.out.println(Messages.COMMAND_LIST);
                break;
        }
    }

    private void extractedUnluckyNumbers(String[] args) {
        if (args.length > 7) {
            System.out.println(Messages.TOO_MANY_NUMBERS);
            System.exit(0);
        } else {
            for (int i = 1; i < args.length; i++) {
                int number;
                try {
                    number = Integer.parseInt(args[i]);
                } catch (NumberFormatException e) {
                    System.err.println(Messages.WRONG_FORMAT);
                    System.exit(0);
                    return;
                }

                if (args[0].equals("6aus49") && number >= 1 && number <= 49) {
                    processedArgs.add(number);
                } else if (args[0].equals("Eurojackpot") && number >= 1 && number <= 50) {
                    processedArgs.add(number);
                } else if (args[0].equals("setunluckynumbers") && number >= 1 && number <= 50) {
                    processedArgs.add(number);
                } else {
                    switch (args[0]) {
                        case "6aus49" -> System.out.println(Messages.NUMBER_OUT_OF_RANGE1);
                        case "Eurojackpot" -> System.out.println(Messages.NUMBER_OUT_OF_RANGE2);
                        case "setunluckynumbers" -> System.out.println(Messages.NUMBER_OUT_OF_RANGE3);
                    }
                    System.exit(0);
                }
            }
        }
    }

    private void process6aus49(List<Integer> processedArgs) {
        Lotto6aus49 lotto = new Lotto6aus49();
        System.out.println(lotto.generateRandomNumbers(processedArgs));
    }

    private void processEurojackpot(List<Integer> processedArgs) {
        Eurojackpot eurojackpot = new Eurojackpot();
        System.out.println(eurojackpot.generateRandomNumbers(processedArgs));
    }

    private void setUnluckyNumbers(List<Integer> processedArgs) {

    }

    private void deleteUnluckyNumbers() {
    }

    private void showUnluckyNumbers() {
    }
}

