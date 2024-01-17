package New.AbstractClass;

import New.Interface.LotteryInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class LotteryGame implements LotteryInterface {
    protected static List<Integer> unluckyNumbers = new ArrayList<>();

    @Override
    public void setUnluckyNumbers(List<Integer> unluckyNumbers) {
        this.unluckyNumbers = unluckyNumbers;
    }

}
