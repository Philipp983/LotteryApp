package Interface;

import java.util.List;

/**
 * The LotteryType interface that defines the methods that the Lottery and Eurojackpot classes must implement.
 */
public interface LotteryType {

    List<Integer> generateRandomNumbers();

    void newUnluckyNumbers();
}
