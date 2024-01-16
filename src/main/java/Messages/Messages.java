package Messages;

public class Messages {

    private Messages() {
    }

    public static final String START_COMMAND = "Please choose the game: Please type '6aus49' or 'Eurojackpot' to choose a game mode, or 'Exit' to close the program.\" \n";
    public static final String END_COMMAND = "Thanks for playing! See you soon!";
    public static final String ENTERING_UNLUCKY_NUMBERS = "Please enter up to 6 unlucky numbers from 1 to 49. Pressing enter without a number will end the sequence. ";
    public static final String ALREADY_EXISTS_UNLUCKY_NUMBER = "You have already entered the same number. Please choose another number";
    public static final String INVALID_UNLUCKY_NUMBER = "Invalid number! Please enter the remaining numbers from 1 to 49 ";
    public static final String ACTION_COMMAND = "Please choose an action:  1-Generate Random Numbers    2-Exit    3-Back to starting Menu    4-Enter unlucky Numbers\n" +
            "5-Display unlucky numbers";
    public static final String WRONG_PROMPT = "Invalid choice. Please type '6aus49' or 'Eurojackpot' to choose a game mode, or 'Exit' to close the program.";

}
