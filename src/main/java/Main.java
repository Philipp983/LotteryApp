import New.Controller.ParameterController;
import Old.Utility.FileUtil;

public class Main {

    public static void main(String[] args) {

        FileUtil.newFile();

        ParameterController controller = new ParameterController();
        controller.processCommands(args);

    }
}
