package hackerearth.Ge;

import java.util.Scanner;

public class Test2 {

    static int M = 1000000007;

    public static void main(String args[]) {


        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int ttt = 0; ttt < t; ttt++) {

            long N = scanner.nextInt();
            if (N <= 1) {
                System.out.println(1);
            } else {

                long n = N / 2 - 1;
                long k = n / 2;
                long ans = 0;
                if (k % 3 == 0) {
                    ans = (k / 3) * ((k + 1) * (3 * n + 2 - 2 * k)) % M;
                } else if ((k + 1) % 3 == 0) {
                    ans = ((k + 1) / 3) * (k * (3 * n + 2 - 2 * k)) % M;
                } else {
                    ans = ((3 * n + 2 - 2 * k) / 3) * (k * (k + 1)) % M;
                }

                ans = ans % M;
                if (n % 2 != 0) {
                    long tt = 1 + n / 2;
                    ans = ans + (tt * tt)%M;
                }
                ans = (2 * ((ans * 4)%M + ((n + 1) * (n + 3))%M))%M + 1;
                System.out.println(ans % 1000000007);
            }
        }
    }
}
