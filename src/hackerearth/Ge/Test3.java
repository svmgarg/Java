package hackerearth.Ge;

import java.util.Scanner;

public class Test3 {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int k = scanner.nextInt();
        char chrs[] = str.toCharArray();
        for (int i = 0; i < chrs.length && k > 0; i++) {
            if (123 - chrs[i] <= k) {
                k = k - 123 + chrs[i];
                chrs[i] = 97;
            }
        }

        if (k > 0) {
            int temp = (chrs[chrs.length-1] + k-96) % 26;
            temp = temp ==0?26 :temp;
            chrs[chrs.length - 1] = (char) (temp+  96);
        }


        System.out.println(String.valueOf(chrs));


    }
}
