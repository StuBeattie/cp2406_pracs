package cp2406;

public class Ch5p1main {
    public static void main(String[] args) {
        PairOfDice g = new PairOfDice();

        g.roll();
        System.out.println("die1 = " + g.getDie1());
        System.out.println("die2 = "+g.getDie2());

        System.out.println("" + g);

        int sum = 0;
        int count = 0;
        while (sum != 2) {
            g.roll();
            count++;
            sum = g.getSum();
        }
        System.out.println("count = " + count);
    }
}
