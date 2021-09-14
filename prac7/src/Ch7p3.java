import java.util.Arrays;


public class Ch7p3 {
    public static void mainOLD(String[] args) {
        int n = 100000;
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.random();
//            System.out.println("" + arr[i]);
        }
        myRunTime(arr);
    }

    public static void main(String[] args) {
        int n = 10000;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            int myLen = (int) (Math.random() * 100) + 1;
            arr[i] = makeRandomString(myLen);
        }
        myRunTimeString(arr);
    }

    private static String makeRandomString(int myLen) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < myLen; i++) {
            char c = (char) (Math.random() * 255);
            builder.append(c);
        }
        String res = builder.toString();
        System.out.println("" + res);
        return res;
    }

    public static void myRunTimeString(String[] arr) {
        long start = System.nanoTime();
        // do something
        Arrays.sort(arr);
        selectionSortString(arr);
        long endTime = System.nanoTime();
        double seconds = (endTime - start) / 1_000_000_000.0;
        System.out.println("seconds = " + seconds);
    }

    public static void myRunTime(double[] arr) {
        long start = System.nanoTime();
        // do something
        Arrays.sort(arr);
//        selectionSort(arr);
        long endTime = System.nanoTime();
        double seconds = (endTime - start) / 1_000_000_000.0;
        System.out.println("seconds = " + seconds);
    }

    private static void selectionSort(double[] numbers) {
        for (int top = numbers.length - 1; top > 0; top--) {
            int maxloc = 0;
            for (int i = 1; i <= top; i++) {
                if (numbers[i] > numbers[maxloc])
                    maxloc = i;
            }
            double temp = numbers[top];
            numbers[top] = numbers[maxloc];
            numbers[maxloc] = temp;
        }
    }

    private static void selectionSortString(String[] arr) {
        for (int top = arr.length - 1; top > 0; top--) {
            int maxloc = 0;
            for (int i = 1; i <= top; i++) {
                if (arr[i].compareTo(arr[maxloc]) > 0) {
                    maxloc = i;
                }
            }
            String temp = arr[top];
            arr[top] = arr[maxloc];
            arr[maxloc] = temp;
        }
    }
}
