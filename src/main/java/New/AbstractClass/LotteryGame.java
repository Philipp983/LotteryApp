package New.AbstractClass;

import New.Interface.LotteryInterface;

import java.util.List;

public abstract class LotteryGame implements LotteryInterface {
    protected List<Integer> unluckyNumbers;

    @Override
    public void setUnluckyNumbers(List<Integer> unluckyNumbers) {
        this.unluckyNumbers = unluckyNumbers;
    }

}
