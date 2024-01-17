package New.Interface;

import java.util.List;

public interface LotteryInterface {

    List<Integer> generateRandomNumbers();

    void newUnluckyNumbers();

    void setUnluckyNumbers(List<Integer> unluckyNumbers);

    void deleteUnluckyNumbers();

    void showUnluckyNumbers();
}
