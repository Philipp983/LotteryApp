package New.Controller;

public class ParameterController {

    public void processCommands(String[] args) {
        String lotteryType = args.length > 0 ? args[0] : "6aus49";

        switch (lotteryType) {
            case "6aus49":
                process6aus49(args);
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
                System.out.println("Invalid lottery type. Please use either '6aus49' or 'Eurojackpot'.");
                break;
        }
    }

    private void process6aus49(String[] args) {

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
