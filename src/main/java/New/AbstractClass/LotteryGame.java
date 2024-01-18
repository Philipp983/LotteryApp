package New.AbstractClass;

import New.Interface.LotteryInterface;
import New.Utility.FileWriter;

import java.util.List;

public abstract class LotteryGame implements LotteryInterface {
    protected List<Integer> unluckyNumbers = FileWriter.read();

    public List<Integer> getUnluckyNumbers() {
        return unluckyNumbers;
    }

    public void loadUnluckyNumbers() {
    }

    public void setUnluckyNumbers(List<Integer> unluckyNumbers) {
        this.unluckyNumbers = unluckyNumbers;
    }


}
