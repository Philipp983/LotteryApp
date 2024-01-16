import Controller.LotteryMenuController;
import Utility.FileUtil;

public class Main {

    public static void main(String[] args) {

        FileUtil.newFile();
        LotteryMenuController menuController = new LotteryMenuController();
        menuController.displayMainMenu();

    }
}
