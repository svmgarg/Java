package hackerearth.julyCircuit2018;

import java.util.*;

public class Problem2 {
    static TreeSet<Integer> c, a;

    public static boolean isExist(int num) {
        int temp;
        for (int t : a) {
            temp = t + num;
            for (int y : c) {
                if (y == temp) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        a = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            a.add(s.nextInt());
        }
        int M = s.nextInt();
        c = new TreeSet<>();

        for (int i = 0; i < M; i++) {
            c.add(s.nextInt());
        }
        TreeSet<Integer> nar = new TreeSet<>();
        int temp;
        int amin = a.first();
        int amax = a.last();
        int cmin = c.first();
        int cmax = c.last();
        int min = cmin -amin;
        int max = cmax -amax;
        for(int k : a){
            for (int p : c) {
                temp = p-k;
                if (temp > 0 && min<=temp && max>=temp) {
                    nar.add(temp);
                }
            }
        }
        StringBuilder l = new StringBuilder();
        for (int t : nar) {
            if (isExist(t)) {
                l.append(t);
                l.append(" ");
            }
        }
        System.out.println(l.toString());

    }
}
