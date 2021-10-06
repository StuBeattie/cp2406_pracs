import textio.TextIO;

public class Ch8p1 {

    public static void main(String[] args) {

        double A; // Coefficients in the equation.
        double B;
        double C;
        double solution;
        boolean tryAgain;  // Set to true if the user wants to solve another equation

        System.out.println("This program will solve the following equation");
        System.out.println("of the form A*X*X + B*X + C = 0, where A, B, and");
        System.out.println("C are values that you enter.");

        do {
            /* Get the coefficients from the user. */
            System.out.println();
            System.out.println("Enter values for A, B, and C:");
            System.out.print("A = ");
            A = TextIO.getlnDouble();
            System.out.print("B = ");
            B = TextIO.getlnDouble();
            System.out.print("C = ");
            C = TextIO.getlnDouble();
            System.out.println();

         // Print the solution, or catch an error and print a warning if there is no solution.
            try {
                solution = root(A,B,C);
                System.out.println("A solution of the equation is " + solution);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Sorry, I can't find a solution.");
                System.out.println(e.getMessage());
            }
            /// See if the user wants to have another go.
            System.out.println();
            System.out.print("Do you want to solve another equation? ");
            tryAgain = TextIO.getlnBoolean();

        } while (tryAgain);
    }

    static public double root( double A, double B, double C )
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        }
        else {
            double disc = B*B - 4*A*C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return  (-B + Math.sqrt(disc)) / (2*A);
        }
    }
}
