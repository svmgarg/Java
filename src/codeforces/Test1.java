package codeforces;

import java.util.Scanner;

public class Test1 {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        String[] str = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int t = Integer.parseInt(str[1]);

        int rem = Integer.MAX_VALUE;
        int index = -1;
        int s = 0;
        int d = 0;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            str = scanner.nextLine().trim().split(" ");
            s = Integer.parseInt(str[0]);
            d = Integer.parseInt(str[1]);

            if(s<t){
                temp = (d - ((t - s) % d)) % d;
            }else{
                temp =s-t;
            }
            if (temp < rem) {
                rem = temp;
                index = i + 1;
            }
        }

        System.out.println(index);

    }
}
