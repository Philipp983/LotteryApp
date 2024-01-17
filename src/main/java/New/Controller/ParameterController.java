package New.Controller;

import New.AbstractClass.LotteryGame;
import New.LotteryModes.Eurojackpot;
import New.LotteryModes.Lotto6aus49;
import New.Messages.Messages;
import New.Utility.FileWriter;
import New.Utility.LogFiles;
import New.Utility.LotteryTicketOutputFormatter;
import New.Utility.UnlimitedLottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParameterController {

    private List<Integer> processedArgs = new ArrayList<>();
    private LogFiles logFiles = new LogFiles();

    public void processCommands(String[] args) {

        logFiles.addToLogs("Start of application");
        logFiles.addToLogs("Passed arguments: " + String.join(" ", args));


        String firstCommand = args.length > 0 ? args[0] : "6aus49";

        if (args.length > 0 && (args[0].equals("6aus49") || args[0].equals("Eurojackpot")
             || args[0].equals("setunluckynumbers")) && args.length > 1) {
            extractedUnluckyNumbers(args);
            FileWriter.write(processedArgs.toString());

        } else if (args.length > 0 && (args[0].equals("6aus49") || args[0].equals("Eurojackpot"))) {

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
            processedArgs = lotteryGame.getUnluckyNumbers();
            //lotteryGame.printUnluckyNumbers();

        }

        switch (firstCommand) {
            case "6aus49":
                process6aus49(processedArgs);
                logFiles.write();
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
            case "clearunluckynumbers":
                FileWriter.clearFile();
                System.out.println(Messages.FILE_CLEARED);
                break;
            case "showunluckynumbers":
                showUnluckyNumbers();
                break;
            case "unlimitedlotto":
                unlimitedLotto(args);
            default:
                System.err.println("\nEingabe: " + firstCommand + " wurde nicht erkannt.");
                System.err.println(Messages.COMMAND_LIST);
                break;
        }
    }

    private void unlimitedLotto(String[] args) {
        if (args.length > 2) {
            extractedUnluckyNumbersForUnlimited(args);
            FileWriter.write(processedArgs.toString());
        }

        try {
            if (args.length > 1 && (args[1].equals("6aus49") || args[1].equals("Eurojackpot"))) {
                LotteryGame lotteryGame;
                switch (args[1]) {
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
                processedArgs = lotteryGame.getUnluckyNumbers();
                //lotteryGame.printUnluckyNumbers();
            }

            UnlimitedLottoGenerator generator = new UnlimitedLottoGenerator(args[1], processedArgs);
            generator.startGenerating();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void extractedUnluckyNumbersForUnlimited(String[] args) {
        if (args.length > 8) {
            System.out.println(Messages.TOO_MANY_NUMBERS);
            System.exit(0);
        } else {
            for (int i = 2; i < args.length; i++) {
                int number;
                try {
                    number = Integer.parseInt(args[i]);
                } catch (NumberFormatException e) {
                    System.err.println(Messages.WRONG_FORMAT);
                    System.exit(0);
                    return;
                }

                if (args[1].equals("6aus49") && number >= 1 && number <= 49) {
                    processedArgs.add(number);
                } else if (args[1].equals("Eurojackpot") && number >= 1 && number <= 50) {
                    processedArgs.add(number);
                } else {
                    switch (args[1]) {
                        case "6aus49" -> System.out.println(Messages.NUMBER_OUT_OF_RANGE1);
                        case "Eurojackpot" -> System.out.println(Messages.NUMBER_OUT_OF_RANGE2);
                    }
                    System.exit(0);
                }
            }
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
        List<Integer> randomNumbers = lotto.generateRandomNumbers(processedArgs);

        LotteryTicketOutputFormatter.modify6aus49Output(randomNumbers);
    }

    private void processEurojackpot(List<Integer> processedArgs) {
        Eurojackpot eurojackpot = new Eurojackpot();
        List<Integer> randomNumbers = eurojackpot.generateRandomNumbers(processedArgs);

        // Assuming the first 5 numbers are from 5aus50 and the last 2 are from 2aus12
        LotteryTicketOutputFormatter.modifyEurojackpotOutput(randomNumbers);
    }

    private void showUnluckyNumbers() {
        List<Integer> numbers = FileWriter.read2();
        if (numbers.isEmpty()) {
            System.out.println(Messages.NO_CURRENT_NUMBERS);
        } else {
            String joinedNumbers = numbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(Messages.CURRENT_NUMBERS + joinedNumbers);
        }
    }
}


