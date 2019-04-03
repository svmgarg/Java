package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HeapSort {

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
        buildMaxHeap(n);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(0, i);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void buildMaxHeap(int n) {

        for (int i = n / 2; i >= 0; i--) {
            heapify(i, n);
        }

    }


    public static void heapify(int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;

        if (l < n && arr[l] > arr[i]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (i != largest) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(largest, n);
        }

    }

}
