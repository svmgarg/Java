package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeSort {

    static int arr[] = new int[]{7, 2, 1, 6, 8, 5, 3, 4, 4};

    static int n = 9;

    public static void getArray() {
        String line;
        int i = 0;
        try (BufferedReader bi = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(bi.readLine());
            arr = new int[n];
            while ((line = bi.readLine()) != null)
                for (String numStr : line.split("\\s"))
                    arr[i++] = Integer.parseInt(numStr);
        } catch (Exception e) {
        }
    }


    public static void main(String args[]) {
        //getArray();
        mergesort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }


    private static void mergesort(int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            mergesort(start, mid);
            mergesort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    private static void merge(int start, int mid, int end) {

        int[] sorted = new int[end - start + 1];

        int l = start;
        int r = mid+1;

        for(int i=0;i < sorted.length;i++){
            if(l > mid ){
                sorted[i] = arr[r++];       // if left part completed then copy right part to sorted
            }else if (r > end){
                sorted[i] = arr[l++];       // if right part completed then copy left part to sorted
            }else if(arr[l] > arr[r]){
                sorted[i] = arr[r++];       // comparing left values and right values
            }else{
                sorted[i] = arr[l++];
            }
        }

        for(int i=0; i < sorted.length;i++){
            arr[start+i] = sorted[i];
        }
}

}
