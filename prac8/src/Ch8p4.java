import java.util.Scanner;

public class Ch8p4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your expression, e.g. sin(x)+3*x:");
        String exprStr = scanner.nextLine();
        System.out.println("Entered expr= " + exprStr);
        Expr expr;
        try {
            expr = new Expr(exprStr);
            while (true) {
                System.out.println("Enter x:");
                String text = scanner.nextLine();
                double x = Double.parseDouble(text);
                System.out.println(expr.value(x));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
