package cp2406;

public class ch2p2 {
    public static void main(String[] args) {

        int d1 = (int)(Math.random()*6) + 1;
        int d2 = (int)(Math.random()*6) + 1;
        int sum = d1 + d2;
        System.out.println("The first dice comes up "+d1+"\n " +
                "The second dice comes up "+d2+"\n" +
                "Your total roll is " + sum);
    }
}
