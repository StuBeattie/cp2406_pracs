package cp2406;

/*
The hexadecimal digits are the ordinary, base-10 digits '0' through '9' plus the letters 'A' through 'F'.
In the hexadecimal system, these digits represent the values 0 through 15, respectively.
Write a function named hexValue that uses a switch statement to find the hexadecimal value of a given character.
The character is a parameter to the function, and its hexadecimal value is the return value of the function.
You should count lower case letters 'a' through 'f' as having the same value as the corresponding upper case letters.
If the parameter is not one of the legal hexadecimal digits, return -1 as the value of the function.

A hexadecimal integer is a sequence of hexadecimal digits, such as 34A7, ff8, 174204, or FADE.
If str is a string containing a hexadecimal integer, then the corresponding base-10 integer can be computed as follows:

value = 0;
for ( i = 0; i < str.length();  i++ )
   value = value*16 + hexValue( str.charAt(i) );
Of course, this is not valid if str contains any characters that are not hexadecimal digits.
Write a program that reads a string from the user. If all the characters in the string are hexadecimal digits,
print out the corresponding base-10 value. If not, print out an error message.
 */

public class Ch4p2Hex2Dec {
    public static void main(String[] args) {
        System.out.println("" + hexValue( '0'));
        System.out.println("" + hexValue( '9'));
        System.out.println("" + hexValue( 'a'));
        System.out.println("" + hexValue( 'b'));
        System.out.println("" + hexValue( 'c'));
        System.out.println("" + hexValue( 'd'));
        System.out.println("" + hexValue( 'e'));
        System.out.println("" + hexValue( 'f'));
        System.out.println("" + hexValue( 'g'));

        System.out.println("value = " + calcIntValue("34A7"));
        System.out.println("value = " + calcIntValue("FADE"));
        System.out.println("value = " + calcIntValue("FADEg"));
    }

    private static int calcIntValue(String str) {
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
//            value = value*16 + hexValue(str.charAt(i));
            int intVal = hexValue(str.charAt(i));
            if (intVal == -1) {
                System.out.println("ERROR: Input is not hexadecimal");
                return  -1;
            }
            value = value * 16 + intVal;
        }
        return value;
    }

    private static int hexValue(char c) {
        c = Character.toLowerCase(c); // 'F' to 'f'
        if (Character.isDigit(c)) {
            return Integer.parseInt( "" + c);
        }
        return switch (c) {
            case 'a' -> 10;
            case 'b' -> 11;
            case 'c' -> 12;
            case 'd' -> 13;
            case 'e' -> 14;
            case 'f' -> 15;
            default -> -1;
        };
    }
}
