package New.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParameterControllerTest {

    private ParameterController controller;

    @BeforeEach
    void setUp() {
        controller = new ParameterController();
    }

    @Test
    void processCommands_Valid6aus49Command_ProcessesCorrectly() {
        String[] args = {"6aus49"};
        controller.processCommands(args);


        // Assertions and verifications
    }

}