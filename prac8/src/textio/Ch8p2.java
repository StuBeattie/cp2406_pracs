package textio;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;


public class Ch8p2 {


    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");


    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );  // for reading user's input.

        String line;   // A line of input from the user.

        BigInteger N;  // The starting point for the 3N+1 sequence,
        //   as specified by the user.

        System.out.println("This program will print 3N+1 sequences for positive starting values");
        System.out.println("The program will end when you press enter with no values.");

        while (true) {
            System.out.println();
            System.out.println("Enter the starting value, or press return to end.");
            System.out.print(">> ");
            line = scanner.nextLine().trim();
            if (line.length() == 0)
                break;
            try {
                N = new BigInteger(line);
                if (N.signum() == 1)
                    printThreeNSequence(N);
                else
                    System.out.println("Error:  The starting value cannot be less than or equal to zero.");
            }
            catch (NumberFormatException e) {
                System.out.println("Error:  \"" + line + "\" is not a legal integer.");
            }
        }
        System.out.println();
        System.out.println("done");

    }
    /**
     * Print the 3N+1 sequence starting from N, and count the number
     * of terms in the sequence.
     * */
    private static void printThreeNSequence(BigInteger N) {

        assert N != null && N.signum() == 1 : "Illegal parameter value.";
        int count;  // The number of terms in the sequence.

        System.out.println();
        System.out.println("The 3N+1 sequence starting with " + N + " is:");
        System.out.println();
        System.out.println(N);   // Print N as the first term of the sequence
        count = 1;

        while ( !Objects.equals(N, ONE)){   // Compute and print the next term
            if (!N.testBit(0)) {
                // N is even.  Divide N by 2.
                N = N.divide(TWO);
            }
            else {
                // N is odd.  Multiply N by 3, then add 1.
                N = N.multiply(THREE);
                N = N.add(ONE);
            }
            System.out.println(N);
            count++;
        }
        System.out.println();
        System.out.println("There were " + count + " terms in the sequence.");
    }
}
