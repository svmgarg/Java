package temp.geeks.Practice1;

import java.util.Scanner;

public class Practice1 {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int tt = Integer.parseInt(scanner.nextLine().trim());
        for (int iii = 0; iii < tt; iii++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            String[] inps = scanner.nextLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < inps.length; i++) {
                arr[i] = Integer.parseInt(inps[i]);
            }
            int p = n - 1;
            int ans = -1;
            for (int i = p - 1; i >= 0; i--) {
                if (arr[i] <= arr[p]) {
                    p = i;
                } else {
                    int max = 0;
                    for (int j = 0; j <= i; j++) {
                        if (arr[j] > max) {
                            max = arr[j];
                        }
                    }
                    for (int k = i + 1; k < n - 1; k++) {
                        if (arr[k] >= max) {
                            ans = arr[k];
                            break;
                        }
                    }
                    break;
                }
            }
            System.out.println(ans);


        }
    }

}