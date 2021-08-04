package cp2406;

import java.util.Locale;
import java.util.Scanner;

public class ch2p3 {
    public static void main(String[] args) {
        System.out.println("Hello");

    /*
    Write a program that asks the user's name,
    and then greets the user by name.
    Before outputting the user's name,
    convert it to upper case letters.
    For example, if the user's name is Fred,
    then the program should respond "Hello, FRED, nice to meet you!".
     */
//        Read from input
        Scanner scanner = new Scanner(System.in);

//        prompt for the users name
        System.out.print("Enter your name: ");

//        get their input as a String
        String username = scanner.next();

//        convert to uppercase
        username = username.toUpperCase(Locale.ROOT);

        System.out.println("Hello " + username);

    } // end main()
} // end class
