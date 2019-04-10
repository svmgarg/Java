package algo.knapsack;

public class KnapsackTest {

    static int val[] = {60, 100, 120};
    static int wt[] = {10, 20, 30};
    static int W = 50;


    public static void main(String args[]) {
        System.out.println(knapsackValue(W, 0));
    }

    public static int knapsackValue(int weight, int n) {

        if (weight == 0 || n == 3) {
            return 0;
        } else if (weight < wt[n]) {
            return knapsackValue(weight, n + 1);
        } else {
            return Math.max(knapsackValue(weight, n + 1), knapsackValue(weight - wt[n], n + 1) + val[n]);
        }

    }
}
