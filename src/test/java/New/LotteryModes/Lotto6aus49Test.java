package New.LotteryModes;

import static org.junit.jupiter.api.Assertions.*;

import New.Messages.Messages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Lotto6aus49Test {

    private Lotto6aus49 lotto6aus49;

    @BeforeEach
    void setUp() {
        lotto6aus49 = new Lotto6aus49();
    }

    @Test
    void generateRandomNumbers_StandardConditions_ReturnsSixNumbers() {
        List<Integer> unluckyNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> randomNumbers = lotto6aus49.generateRandomNumbers(unluckyNumbers);

        assertEquals(6, randomNumbers.size());
        randomNumbers.forEach(num -> assertFalse(unluckyNumbers.contains(num)));
    }

    @Test
    void loadUnluckyNumbers_OutOfRangeNumbers_ThrowsException() {
        List<Integer> outOfRangeNumbers = Arrays.asList(50, 51, 52);
        lotto6aus49.setUnluckyNumbers(outOfRangeNumbers);

        Exception exception = assertThrows(IllegalArgumentException.class, lotto6aus49::loadUnluckyNumbers);
        assertEquals(Messages.LOADED_NUMBER_OUT_OF_RANGE1, exception.getMessage());
    }

    @Test
    void loadUnluckyNumbers_OutOfRangeNumbers_ThrowsException1() {
        List<Integer> outOfRangeNumbers = Arrays.asList(2, 6, 12);
        lotto6aus49.setUnluckyNumbers(outOfRangeNumbers);

        assertDoesNotThrow(lotto6aus49::loadUnluckyNumbers);
    }
}
