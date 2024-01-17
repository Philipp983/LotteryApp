package New.Interface;

import java.util.List;

public interface LotteryInterface {

    List<Integer> generateRandomNumbers(List<Integer> unluckyNumbers);

    void newUnluckyNumbers();


    void deleteUnluckyNumbers();

    void showUnluckyNumbers();

    void loadUnluckyNumbers();
}
