package algo.maximumSumIncreasingSubsequence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static int[] arr = {13, 101, 5, 11, 100, 4, 5};

    public static void main(String args[]) {

        function();


    }

    public static void function() {

        int[] ms = new int[arr.length];
        int[] seq = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ms[i] = arr[i];
            seq[i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if ((arr[i] + ms[j]) > ms[i]) {
                        ms[i] = arr[i] + ms[j];
                        seq[i] = j;
                    }
                }
            }

        }
        //{13, 101, 5, 11, 100, 4, 5};

        System.out.println(Arrays.stream(ms).max().getAsInt());
    }

}
