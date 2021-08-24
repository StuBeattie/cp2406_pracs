package cp2406;

/*
Test your new class by using it in a program to compute statistics
for a set of non-zero numbers entered by the user.
Start by creating an object of type StatCalc:

StatCalc  calc;   // Object to be used to process the data.
calc = new StatCalc();
Read numbers from the user and add them to the dataset.
Use 0 as a sentinel value (that is, stop reading numbers when the user enters 0).
After all the user's non-zero numbers have been entered,
print out each of the six statistics that are available from calc.
 */

import java.util.Scanner;

public class Ch5p2main {
    public static void main(String[] args) {
        StatCalc calc = new StatCalc();
        int userInt = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        while (userInt != 0) {
            System.out.print("Please enter int number: ");
            userInt = scanner.nextInt();
            System.out.println("got " + userInt);
            if (userInt != 0) {
                calc.enter(userInt);
            }
        }
        System.out.println("Done");
        System.out.println("Mean = " + calc.getMean());
        System.out.println("Std = " + calc.getStandardDeviation());
        System.out.println("Sum = " + calc.getSum());
        System.out.println("Count = " + calc.getCount());
        System.out.println("Min = " + calc.getMin());
        System.out.println("Max = " + calc.getMax());
    }
}
