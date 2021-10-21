import java.math.BigInteger;

public class Ch9p1 {
    public static BigInteger minusOne = new BigInteger("-1");
    public static BigInteger minusTwo = new BigInteger("-2");
    public static BigInteger one = new BigInteger("1");
    public static BigInteger zero = new BigInteger("0");

    public  static void main(String[] args) {
        BigInteger n = new BigInteger("2");
        System.out.println("factorial n!=" + factorial(n));
        System.out.println("fibonacci(n)=" + fibonacci(n));
    }
    public static BigInteger factorial(BigInteger n) {
        System.out.println("n = " + n);

        if (n.equals(one) || n.equals(zero)) {
            return one;
        }
        BigInteger res = factorial(n.add(minusOne));
        res = res.multiply(n);
        return res;
    }

    public  static BigInteger fibonacci(BigInteger n) {
        System.out.println("n = " + n);

        if (n.equals(one) || n.equals(zero)) {
            return one;
        }
        BigInteger res1 = fibonacci(n.add(minusOne));
        BigInteger res2 = fibonacci(n.add(minusTwo));
        return res1.add(res2);
    }

}
