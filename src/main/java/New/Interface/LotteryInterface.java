package New.Interface;

import java.util.List;

public interface LotteryInterface {

    List<Integer> generateRandomNumbers(String[] args);

    void newUnluckyNumbers();

    void setUnluckyNumbers(List<Integer> unluckyNumbers);

    void deleteUnluckyNumbers();

    void showUnluckyNumbers();
}
