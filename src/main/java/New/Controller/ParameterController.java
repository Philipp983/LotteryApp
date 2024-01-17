package New.Controller;

import New.LotteryModes.Lotto6aus49;
import New.Messages.Messages;

import java.util.ArrayList;
import java.util.List;

public class ParameterController {

    private List<Integer> processedArgs = new ArrayList<>();

    public void processCommands(String[] args) {

        String firstCommand = args.length > 0 ? args[0] : "6aus49";

        if ((args[0].equals("6aus49") || args[0].equals("Eurojackpot")
             || args[0].equals("setunluckynumbers")) && args.length > 1) {
            extractedUnluckyNumbers(args);
        }

        switch (firstCommand) {
            case "6aus49":
                process6aus49(processedArgs);
                break;
            case "Eurojackpot":
                processEurojackpot(args);
                break;
            case "setunluckynumbers":
                setUnluckyNumbers(args);
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
                    if (args[0].equals("6aus49")) {
                        System.out.println(Messages.NUMBER_OUT_OF_RANGE1);
                    } else if (args[0].equals("Eurojackpot")) {
                        System.out.println(Messages.NUMBER_OUT_OF_RANGE2);
                    } else if (args[0].equals("setunluckynumbers")) {
                        System.out.println(Messages.NUMBER_OUT_OF_RANGE3);
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

    private void processEurojackpot(String[] args) {
    }

    private void setUnluckyNumbers(String[] args) {
    }

    private void deleteUnluckyNumbers() {
    }

    private void showUnluckyNumbers() {
    }
}

