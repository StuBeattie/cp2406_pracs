package cp2406;

import java.util.Scanner;

public class ch2p4 {
    public static void main(String[] args) {
        System.out.println("Hello");

    /*
    Write a program that helps the user count his change.
    The program should ask how many quarters the user has, then how many dimes,
    then how many nickels, then how many pennies.
    Then the program should tell the user how much money he has, expressed in dollars.
     */

        Scanner scanner = new Scanner(System.in);

        System.out.print("how many quarters: ");
        int numQuarters = scanner.nextInt();
        scanner.nextLine(); // this is used to prevent user inputting more than 1 input on a single line
        System.out.println("Inputted: " + numQuarters);

        System.out.print("how many dimes: ");
        int numDimes = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inputted: " + numDimes);

        System.out.print("how many nickels: ");
        int numNickels = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inputted: " + numNickels);

        System.out.print("how many pennies: ");
        int numPennies = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inputted: " + numPennies);

        int sum = 25 * numQuarters + 10 * numDimes + 5 * numNickels + numPennies;
        System.out.println("sum $" + sum/100.0);

    }
}
