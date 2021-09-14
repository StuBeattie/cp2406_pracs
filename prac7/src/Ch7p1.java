import java.util.ArrayList;

public class Ch7p1 {
    public static void main(String[] args) {
        System.out.println("Ex7.1");
//        ArrayList<Integer> arr = new ArrayList<>();
        int testSize = 100;
        int testMaxVal = 20;
        ArrayList<Integer> arr = makeIntArray(testSize, testMaxVal);
        System.out.println("arr.size()" + arr.size());
        if (arr.size() == testSize) {
            System.out.println("testSize PASSED");
        } else {
            System.out.println("testSize ERROR");
            return;
        }
        int myMax = -Integer.MAX_VALUE;
        for (int v : arr) {
            if (v > myMax) {
                myMax = v;
            }
        }
        if (myMax <= testMaxVal) {
            System.out.println("testMaxVal PASSED");
        } else {
            System.out.println("testMaxVal ERROR");
        }
    }
    public static ArrayList<Integer> makeIntArray(int arrSize, int maxVal) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrSize; i++) {
             int v = (int )(Math.random() * maxVal) + 1;
            System.out.println("" + v);
             arr.add(v);

        }
        return arr;
    }
}
