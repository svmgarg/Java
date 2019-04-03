package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {


    static int arr[] = new int[]{7 ,2 ,1, 6, 8 ,5 ,3 ,4};
    static int n = 8;

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
        quickSort(0, n-1);
        for(int i =0; i <n;i++){
            System.out.print(arr[i]+"\t");
        }


    }

    public static void quickSort(int start, int end) {

        if (start < end) {
            int partition = getPartition(start, end);
            quickSort(start, partition-1);
            quickSort(partition+1, end);

        }
    }
    private static int getPartition(int start, int end) {

        int pivot = arr[end];
        int i = (start-1); // index of smaller element
        for (int j=start; j<end; j++)
        {

            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;
    }

}