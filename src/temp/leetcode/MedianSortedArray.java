package temp.leetcode;

import java.util.Scanner;
import java.util.stream.Stream;

public class MedianSortedArray {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int[] arr1 = Stream.of(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Stream.of(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(median(arr1, arr2));
    }


    public static int median(int[] arr1, int[] arr2) {

        int n = arr1.length + arr2.length;
        int l = 0;
        int r = 0;
        for (int i = 1; i <= n / 2; i++) {

            if(arr1[l] <  arr2[r]){
                l++;
            }else{
                r++;
            }
        }
        if(n %2 ==0){
            return (arr1[l] + arr2[r])/2;
        }else{
            return arr1[l] < arr2[r] ? arr1[l]: arr2[r];
        }

    }
}
