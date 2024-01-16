import GameModes.Eurojackpot;
import GameModes.Lottery;

public class Main {

    public static void main(String[] args) {

//        Lottery lottery = new Lottery();
//
//        System.out.println(lottery.generateRandomNumbers());
//        System.out.println(lottery.generateRandomNumbers());
//        System.out.println(lottery.generateRandomNumbers());
//        System.out.println(lottery.generateRandomNumbers());
//        System.out.println(lottery.generateRandomNumbers());

        Eurojackpot eurojackpot = new Eurojackpot();

        System.out.println(eurojackpot.generateRandomNumbers());
        System.out.println(eurojackpot.generateRandomNumbers());
        System.out.println(eurojackpot.generateRandomNumbers());
        System.out.println(eurojackpot.generateRandomNumbers());
        System.out.println(eurojackpot.generateRandomNumbers());

    }
}
