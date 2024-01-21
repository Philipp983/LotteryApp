package New.Utility;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UnlimitedLottoGeneratorTest {

    @Test
    void testRun() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        List<Integer> unluckyNumbers = Arrays.asList(13, 17, 19);
        UnlimitedLottoGenerator generator = new UnlimitedLottoGenerator("6aus49", unluckyNumbers);

        Thread generatorThread = new Thread(generator);
        generatorThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generator.stopGenerating();

        System.setOut(System.out);

        assertTrue(outputStreamCaptor.toString().contains("Tippschein Nummer 1:"));
    }
}
