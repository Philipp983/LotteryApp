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
import java.util.List;
import java.util.stream.Collectors;

/**
 * The ParameterController class that is responsible for processing command line arguments
 * and executing the corresponding functionalities for a lottery application.
 * The README file gives an overview of the different commands that are available.
 */
public class ParameterController {

    private List<Integer> processedArgs = new ArrayList<>();

    /**
     * Processes the provided command-line arguments to execute the corresponding lottery game functions.
     * This method handles different commands and their respective logic, including generating lottery numbers,
     * managing unlucky numbers, and starting unlimited lottery ticket generation.
     *
     * @param args the command-line arguments passed to the application.
     */
    public void processCommands(String[] args) {

        LogFiles.getInstance().addToLogs("Start of application");
        LogFiles.getInstance().addToLogs("Passed arguments: " + String.join(" ", args));


        String firstCommand = args.length > 0 ? args[0] : "6aus49";

        if (args.length > 0 && (args[0].equals("6aus49") || args[0].equals("Eurojackpot")
             || args[0].equals("setunluckynumbers")) && args.length > 1) {
            LogFiles.getInstance().addToLogs("Separating numbers");
            extractedUnluckyNumbers(args);

            FileWriter.write(processedArgs.toString());
            LogFiles.getInstance().addToLogs("Saved unlucky numbers to unlucky-numbers.txt");


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
            try {
                lotteryGame.loadUnluckyNumbers();
            } catch (IllegalArgumentException e) {
                System.exit(0);
            }
            processedArgs = lotteryGame.getUnluckyNumbers();
            //lotteryGame.printUnluckyNumbers();

        }

        switch (firstCommand) {
            case "6aus49":
                Lotto6aus49 loadchecker = new Lotto6aus49();

                try {
                    loadchecker.loadUnluckyNumbers();
                } catch (IllegalArgumentException e) {
                    System.exit(0);
                }

                LogFiles.getInstance().addToLogs("Passing unlucky numbers to 6aus49");
                process6aus49(processedArgs);
                LogFiles.getInstance().addToLogs("End of application");
                LogFiles.getInstance().write();
                break;
            case "Eurojackpot":
                LogFiles.getInstance().addToLogs("Passing unlucky numbers to Eurojackpot");
                processEurojackpot(processedArgs);

                LogFiles.getInstance().addToLogs("End of application");
                LogFiles.getInstance().write();
                break;
            case "setunluckynumbers":
                if (args.length == 1) {
                    System.out.println(Messages.NO_NEW_NUMBERS_PASSED);
                    LogFiles.getInstance().addToLogs("No unlucky numbers passed");
                } else {
                    System.out.println(Messages.NEW_NUMBERS);
                }

                LogFiles.getInstance().addToLogs("End of application");
                LogFiles.getInstance().write();
                break;
            case "clearunluckynumbers":
                FileWriter.clearFile();

                LogFiles.getInstance().addToLogs("unlucky-numbers.txt was cleared");

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

                LogFiles.getInstance().addToLogs("command '" + firstCommand + "' not recognized");
                LogFiles.getInstance().addToLogs("End of application");
                LogFiles.getInstance().write();
                break;
        }
    }

    /**
     * Handles the "unlimitedlotto" command to start a continuous generation of lottery tickets.
     * It processes additional arguments for setting up the lottery game and unlucky numbers.
     *
     * @param args the command-line arguments, including the lottery type and optional unlucky numbers.
     */
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

    /**
     * Extracts unlucky numbers from the command-line arguments for the "unlimitedlotto" command.
     * It validates the numbers and adds them to the processedArgs list.
     *
     * @param args the command-line arguments containing the unlucky numbers.
     */
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

    /**
     * Extracts unlucky numbers from the command-line arguments for setting or modifying unlucky numbers.
     * It performs validation and updates the processedArgs list with the extracted numbers.
     *
     * @param args the command-line arguments containing the unlucky numbers.
     */
    private void extractedUnluckyNumbers(String[] args) {
        if (args.length > 7) {
            System.out.println(Messages.TOO_MANY_NUMBERS);
            LogFiles.getInstance().addToLogs("Too many arguments passed, only up to 6 numbers allowed.");
            LogFiles.getInstance().addToLogs("End of application");
            LogFiles.getInstance().write();
            System.exit(0);
        } else {
            for (int i = 1; i < args.length; i++) {
                int number;
                try {
                    number = Integer.parseInt(args[i]);
                } catch (NumberFormatException e) {
                    System.err.println(Messages.WRONG_FORMAT);
                    LogFiles.getInstance().addToLogs("Separating number failed: " + e + ". Wrong format passed");
                    LogFiles.getInstance().addToLogs("End of application");
                    LogFiles.getInstance().write();
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
                        case "6aus49" -> {
                            System.out.println(Messages.NUMBER_OUT_OF_RANGE1);
                            LogFiles.getInstance().addToLogs("Separating numbers failed: " + number + " is out of range");
                        }
                        case "Eurojackpot" -> {
                            System.out.println(Messages.NUMBER_OUT_OF_RANGE2);
                            LogFiles.getInstance().addToLogs("Separating numbers failed: " + number + " is out of range");
                        }
                        case "setunluckynumbers" -> {
                            System.out.println(Messages.NUMBER_OUT_OF_RANGE3);
                            LogFiles.getInstance().addToLogs("Separating numbers failed: " + number + " is out of range");
                        }
                    }

                    LogFiles.getInstance().addToLogs("End of application");
                    LogFiles.getInstance().write();
                    System.exit(0);
                }

                LogFiles.getInstance().addToLogs("Separating number " + number + " successfull");
            }
        }
    }

    /**
     * Processes and generates lottery numbers for the "6aus49" game.
     * It uses the processedArgs list for unlucky numbers exclusion.
     *
     * @param processedArgs the list of unlucky numbers to exclude from the lottery draw.
     */
    private void process6aus49(List<Integer> processedArgs) {
        Lotto6aus49 lotto = new Lotto6aus49();
        List<Integer> randomNumbers = lotto.generateRandomNumbers(processedArgs);

        LotteryTicketOutputFormatter.modify6aus49Output(randomNumbers);
    }

    /**
     * Processes and generates lottery numbers for the "Eurojackpot" game.
     * It uses the processedArgs list for unlucky numbers exclusion.
     *
     * @param processedArgs the list of unlucky numbers to exclude from the lottery draw.
     */
    private void processEurojackpot(List<Integer> processedArgs) {
        Eurojackpot eurojackpot = new Eurojackpot();
        List<Integer> randomNumbers = eurojackpot.generateRandomNumbers(processedArgs);

        LotteryTicketOutputFormatter.modifyEurojackpotOutput(randomNumbers);
    }

    /**
     * Displays the currently set unlucky numbers to the user.
     * It reads the numbers from the file and prints them to the console.
     */
    private void showUnluckyNumbers() {
        List<Integer> numbers = FileWriter.read();
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


