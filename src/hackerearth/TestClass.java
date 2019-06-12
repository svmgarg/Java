package hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int tt = 0; tt < t; tt++) {

            long l = s.nextLong();

            long sqrt = Double.valueOf(Math.sqrt(l)).longValue();
            ArrayList<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= sqrt; i++) {
                if (l % i == 0) {
                    factors.add(i);
                }
            }
            ArrayList<State> queue = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            queue.add(new State(0, temp, factors.size()));
            int ans = 0;
            long cc = 0;
            while (!queue.isEmpty()) {

                State st = queue.get(0);
                for (int i = st.counter - 1; i >= 0; i--) {
                    if (st.sum + factors.get(i) * factors.get(i) < l) {
                        temp = new ArrayList<>(st.list);
                        temp.add(factors.get(i));
                        queue.add(new State(st.sum + factors.get(i) * factors.get(i), temp, i));
                        //System.out.println("adding " + ++cc);
                    } else if (st.sum + factors.get(i) * factors.get(i) == l) {
                        ans = ans + 1;

                    }
                }

                queue.remove(0);
            }
            System.out.println(ans);


        }


    }

    static class State {

        long sum;
        ArrayList<Integer> list;
        int counter;

        public State(long sum, ArrayList<Integer> list, int counter) {
            this.sum = sum;
            this.list = list;
            this.counter = counter;
        }
    }

}
