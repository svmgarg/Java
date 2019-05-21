package temp.techgigs.standardcharteredbank.Test1;

import java.util.Scanner;

public class Test {

    static Integer[][] mat;

    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine().trim());
        int N = Integer.parseInt(scanner.nextLine().trim());
        int P = Integer.parseInt(scanner.nextLine().trim());
        int Q = Integer.parseInt(scanner.nextLine().trim());
        int temp = 0;
        if (M > N) {
            temp = M;
            M = N;
            N = temp;
        }
        if (P > Q) {
            temp = P;
            P = Q;
            Q = temp;
        }
        temp = Math.max(N, Q);
        mat = new Integer[temp][temp];
        for (int i = 0; i <= temp; i++) {
            mat[i][i] = 1;
            mat[i][0] = 0;
            mat[0][i] = 0;
        }
        long ans = 0;
        for (int i = M; i <= N; i++) {
            for (int j = P; j <= Q; j++) {
                ans = ans + cal(i, j);
            }
        }
        System.out.println(ans);
    }

    static Integer cal(int i, int j) {

        if (mat[i][j] == null) {
            Integer temp;
            if (i > j) {
                temp = cal(j, j) + cal(i - j, j);
            } else {
                temp = cal(i, i) + cal(i, j - i);
            }
            mat[i][j] = temp;
            mat[j][i] = temp;
            return temp;
        } else {
            return mat[i][j];
        }


    }

}
