package algo.nQueensProblem;


import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Start {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(scanner.nextLine().trim());
            int[] st = new int[k + 1];
            process(st, 1, k);

        }
    }

    static void process(int[] st, int col, int k) {
        for (int i = 1; i <= k; i++) {
            st[col] = i;
            if (valid(st, col, k) && (col + 1) <= k) {
                //System.out.println(col);
                process(st, col + 1, k);
            }
            st[col] = 0;
        }

    }

    static boolean valid(int[] st, int col, int k) {
        int temp = -1;
        for (int i = col - 1; i > 0; i--) {
            temp = col - i;
            if (st[col] == st[i] || (st[col] - temp) == st[i] || (st[col] + temp) == st[i]) {
                return false;
            }
        }
        if (col == k) {

            System.out.print(IntStream.of(st)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(" ")).replace("0 ", ""));
        }
        return true;
    }


}
