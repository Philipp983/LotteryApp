import GameModes.Lottery;

public class Main {

    public static void main(String[] args) {

        Lottery lottery = new Lottery();

        System.out.println(lottery.generateRandomNumbers());
        System.out.println(lottery.generateRandomNumbers());
        System.out.println(lottery.generateRandomNumbers());
        System.out.println(lottery.generateRandomNumbers());
        System.out.println(lottery.generateRandomNumbers());

    }
}
