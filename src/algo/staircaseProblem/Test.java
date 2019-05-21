package algo.staircaseProblem;

//https://www.youtube.com/watch?v=CFQk7OQO_xM
public class Test {


    static int n = 4;
    static int[] cache = new int[n + 1];
    int[] steps = {1, 2};

    public static void main(String args[]) {

        for (int i = 0; i <= n; i++) {
            cache[i] = -1;
        }
        cache[0] = 1;
        System.out.println(function(n));

    }

    public static int function(int i) {
        if (i < 0) {
            return 0;
        } else if (cache[i] == -1) {
            return function(i - 1) + function(i - 2);
        } else {
            return cache[i];
        }

    }
}
