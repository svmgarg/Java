package temp.geeks.Practice2;

import java.util.Scanner;

public class Practice2 {

    static int[] arr;

    static int[] leftheap;

    static int[] rightheap;

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        arr = new int[n];
        for (int iii = 0; iii < n; iii++) {
            findMedian(Integer.parseInt(scanner.nextLine().trim()), iii);

        }
    }

    public static void findMedian(int inp, int n) {

            int i = 0;
            while (i < n && arr[i] < inp) {
                i++;
            }

            for (int kk = n; kk > i; kk--) {
                arr[kk] = arr[kk - 1];
            }
            arr[i] = inp;
            if ((n + 1) % 2 == 0) {
                System.out.println((arr[n / 2] + arr[n / 2 + 1]) / 2);
            } else {
                System.out.println((arr[n / 2]));
            }

    }


    public static void findMedian1(int inp, int n) {

        int i = 0;
        while (i < n && arr[i] < inp) {
            i++;
        }

        for (int kk = n; kk > i; kk--) {
            arr[kk] = arr[kk - 1];
        }
        arr[i] = inp;
        if ((n + 1) % 2 == 0) {
            System.out.println((arr[n / 2] + arr[n / 2 + 1]) / 2);
        } else {
            System.out.println((arr[n / 2]));
        }

    }


}
