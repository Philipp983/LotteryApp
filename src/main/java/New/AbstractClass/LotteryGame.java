package New.AbstractClass;

import New.Interface.LotteryInterface;
import New.Utility.FileWriter;

import java.util.List;

public abstract class LotteryGame implements LotteryInterface {
    protected static List<Integer> unluckyNumbers = FileWriter.read2();

    @Override
    public void setUnluckyNumbers(List<Integer> unluckyNumbers) {
        this.unluckyNumbers = unluckyNumbers;
    }

    public void loadUnluckyNumbers() {
        System.out.println(unluckyNumbers);
    }

}
