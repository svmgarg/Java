package algo.coinChange;

public class CoinChangeTest {

    static int[] c = {1, 2, 3};
    static int n = 5;

    public static void main(String args[]) {

        int mat[][] = new int[c.length][n + 1];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j == 0) {
                    mat[i][j] = 1;
                } else {
                    if (i - 1 >= 0) {
                        mat[i][j] = mat[i - 1][j];
                    }
                    if (j - c[i] >= 0) {
                        mat[i][j] = mat[i][j] + mat[i][j - c[i]];
                    }
                }
            }
        }

        System.out.println(mat[c.length - 1][n]);


        System.out.println(function(0, 0));
    }

    public static int function(int index, int sum) {

        if (sum == n) {
            return 1;
        } else if (sum > n) {
            return 0;
        } else {
            int i = index;
            int ways = 0;
            while (i < c.length) {
                ways = ways + function(i, sum + c[i]);
                i++;
            }
            return ways;
        }
    }
}
