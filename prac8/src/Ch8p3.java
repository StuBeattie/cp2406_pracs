import textio.TextIO;


public class Ch8p3 {

    public static void main(String[] args) {
        System.out.println("Enter a roman numeral and I will convert it to an ordinary");
        System.out.println("arabic integer.  Enter an integer in the range 1 to 3999");
        System.out.println("and the program will convert it to a Roman numeral.");
        System.out.println("Press return when you want to quit.");

        while (true) {
            System.out.println();
            System.out.print(">> ");

            while (TextIO.peek() == ' ' || TextIO.peek() == '\t')
                TextIO.getAnyChar();
            if ( TextIO.peek() == '\n' )
                break;

            if ( Character.isDigit(TextIO.peek()) ) {
                int arabic = TextIO.getlnInt();
                try {
                    RomanNumeral N = new RomanNumeral(arabic);
                    System.out.println(N.toInt() + " = " + N);
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    System.out.println(e.getMessage());
                }
            }
            else {
                String roman = TextIO.getln();
                try {
                    RomanNumeral N = new RomanNumeral(roman);
                    System.out.println(N + " = " + N.toInt());
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Done.");
    }
}