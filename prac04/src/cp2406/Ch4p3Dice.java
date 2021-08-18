package cp2406;

/*
Write a function that simulates rolling a pair of dice until the total on the dice comes up to be a given number.
The number that you are rolling for is a parameter to the function.
The number of times you have to roll the dice is the return value of the function.
The parameter should be one of the possible totals: 2, 3, ..., 12.
The function should throw an IllegalArgumentException if this is not the case.
Use your function in a program that computes and prints the number of rolls it takes to get snake eyes.
(Snake eyes means that the total showing on the dice is 2.)
 */

public class Ch4p3Dice {

    public static void main(String[] args) {
        for (int total = 2; total < 20; total++){
            countNumRolls(total);
        }
    }

    public static void countNumRolls(int total)
            throws IllegalArgumentException {
        if (total < 2 || total > 12) {
            throw new IllegalArgumentException("ERROR: not possible total = " + total);
        }
        int die1, die2;   // The values rolled on the two dice.
        int countRolls;   // Used to count the number of rolls.
        countRolls = 0;
        die1 = (int) (Math.random() * 6) + 1;   // roll the dice
        die2 = (int) (Math.random() * 6) + 1;
        countRolls++;                        // and count this roll
        while ((die1 + die2) != total) {
            die1 = (int) (Math.random() * 6) + 1;   // roll the dice
            die2 = (int) (Math.random() * 6) + 1;
            countRolls++;                        // and count this roll
        }

        System.out.println("It took " + countRolls + " rolls to get total " + total);
    }

}
