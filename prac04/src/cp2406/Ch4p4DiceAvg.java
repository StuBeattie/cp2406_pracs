package cp2406;

/*
This exercise builds on Exercise 4.3.
Every time you roll the dice repeatedly, trying to get a given total,
the number of rolls it takes can be different. The question naturally arises,
what's the average number of rolls to get a given total? Write a function that performs
the experiment of rolling to get a given total 10000 times.
The desired total is a parameter to the subroutine.
The average number of rolls is the return value.
Each individual experiment should be done by calling the function you wrote for Exercise 4.3.
Now, write a main program that will call your function once for each of the possible totals (2, 3, ..., 12).
It should make a table of the results, something like:

Total On Dice     Average Number of Rolls
-------------     -----------------------
       2               35.8382
       3               18.0607
       .                .
       .                .

 */


public class Ch4p4DiceAvg {

    public static void main(String[] args) {
        int numTries = 10_000;
        for (int total = 2; total < 20; total++){
            double res = calcAverageNumRolls(total, numTries);
            System.out.println("" + total + "\t\t" + res);
        }
    }

    public static double calcAverageNumRolls(int total, int numTries)
            throws IllegalArgumentException {
        if (total < 2 || total > 12) {
            throw new IllegalArgumentException("ERROR: not possible total = " + total);
        }
        int die1, die2;   // The values rolled on the two dice.
        int countRolls;   // Used to count the number of rolls.
        countRolls = 0;
        double countValid = 0.0;
        double myCount = 0;
        double mySum = 0;
        while (countRolls < numTries) {
            die1 = (int) (Math.random() * 6) + 1;   // roll the dice
            die2 = (int) (Math.random() * 6) + 1;
            countRolls++;
            myCount++;
            if ((die1 + die2) == total) {
                countValid++;
                mySum += myCount;
                myCount = 0;
            }
        }
        return mySum / countValid;
    }

}
