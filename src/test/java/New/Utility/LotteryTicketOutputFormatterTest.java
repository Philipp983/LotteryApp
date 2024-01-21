package New.Utility;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LotteryTicketOutputFormatterTest {

    @Test
    void testModify6aus49Output() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryTicketOutputFormatter.modify6aus49Output(randomNumbers);

        System.setOut(System.out);

        String expectedOutput = "6aus49 Tippzahlen: 1, 2, 3, 4, 5, 6";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testModifyEurojackpotOutput() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        LotteryTicketOutputFormatter.modifyEurojackpotOutput(randomNumbers);

        System.setOut(System.out);

        String expectedOutput = "Eurojackpot 5aus50: 1, 2, 3, 4, 5\r\n" + //
                "2aus12: 6, 7";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }
}
