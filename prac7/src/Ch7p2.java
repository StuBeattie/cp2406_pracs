public class Ch7p2 {
    public static void main(String[] args) {
        int[][] test1 = {{1, 2}, {3, 4}, {5, 6}};
        myPrint(test1);
        test1 = flipRowsToCols(test1);
        myPrint(test1);
    }
    public static int[][] flipRowsToCols(int[][] arr) {
        int nRows = arr.length;
        int nCols = arr[0].length;
        int[][] res = new int[nCols][nRows];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                 int v = arr[r][c];
                 res[c][r] = v;
            }

        }
        return res;
    }
    public static void myPrint(int[][] arr) {
        int nCols = arr[0].length;
        for (int[] ints : arr) {
            for (int c = 0; c < nCols; c++) {
                int v = ints[c];
                System.out.print("\t" + v);
            }
            System.out.print("\n");
        }
    }
}
