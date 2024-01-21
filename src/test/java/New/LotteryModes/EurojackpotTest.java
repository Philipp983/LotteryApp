package New.LotteryModes;

import New.Messages.Messages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class EurojackpotTest {

    private Eurojackpot eurojackpot;

    @BeforeEach
    void setUp() {
        eurojackpot = new Eurojackpot();
    }

    @Test
    void generateRandomNumbers_StandardConditions_ReturnsSevenNumbers() {
        List<Integer> unluckyNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> randomNumbers = eurojackpot.generateRandomNumbers(unluckyNumbers);

        assertEquals(7, randomNumbers.size());
        assertTrue(randomNumbers.stream().allMatch(num -> num >= 1 && num <= 50));
        assertTrue(randomNumbers.stream().noneMatch(unluckyNumbers::contains));
    }

    @Test
    void loadUnluckyNumbers_OutOfRangeNumbers_ThrowsException() {
        List<Integer> outOfRangeNumbers = Arrays.asList(51, 52, 53);
        eurojackpot.setUnluckyNumbers(outOfRangeNumbers);

        Exception exception = assertThrows(IllegalArgumentException.class, eurojackpot::loadUnluckyNumbers);
        assertEquals(Messages.LOADED_NUMBER_OUT_OF_RANGE2, exception.getMessage());
    }

    @Test
    void loadUnluckyNumbers_OutOfRangeNumbers_ThrowsException1() {
        List<Integer> outOfRangeNumbers = Arrays.asList(2, 6, 12);
        eurojackpot.setUnluckyNumbers(outOfRangeNumbers);

        assertDoesNotThrow(eurojackpot::loadUnluckyNumbers);
    }
}
