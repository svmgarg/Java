package hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

public class Random1 {


    static boolean flag = true;

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine().trim());
        for (int l = 0; l < t; l++) {
            flag = true;
            int n = Integer.parseInt(s.nextLine().trim());
            String[] str = s.nextLine().trim().split(" ");
            int[] inp = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                inp[i] = Integer.parseInt(str[i]);
            }

            int k = Integer.parseInt(s.nextLine().trim());

            ArrayList<State> queue = new ArrayList<>();
            for (int i = 0; i < inp.length; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(inp[i]);
                queue.add(new State(temp, i + 1));

            }
            while ((!queue.isEmpty()) && flag) {
                State state = queue.remove(0);
                if (sum(state.list) == k) {
                    flag = false;
                    System.out.println("YES");
                } else {
                    for (int i = state.counter; i < n; i++) {
                        ArrayList<Integer> temp = new ArrayList<>(state.list);
                        temp.add(inp[state.counter]);
                        queue.add(new State(temp, i + 1));
                    }
                }
            }

            if (flag) {
                System.out.println("NO");
            }


        }


    }

    static class State {

        ArrayList<Integer> list;

        int counter;

        State(ArrayList<Integer> list, int counter) {
            this.list = list;
            this.counter = counter;
        }
    }

    public static int sum(ArrayList<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

}
