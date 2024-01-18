package New.Interface;

import java.util.List;

public interface LotteryInterface {

    List<Integer> generateRandomNumbers(List<Integer> unluckyNumbers);

    void loadUnluckyNumbers();

    void setUnluckyNumbers(List<Integer> unluckyNumbers);
}
