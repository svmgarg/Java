package algo.sort012;

//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
public class Sort012 {

    public static void main(String args[]) {

        int arr[] = {1,0,2,2,1,2,0,1,0,2,1,1,2,2,0,0,1,2,1,0,0,2,0,0,0,1,1,0,2,0,2,1,1,2,0,0,2,1,1,2,1,0,0,0,0,2,0,0,1,2,0,1,2,1,1,2,2,0,0,2,1,0,0,0,0,1,0,0,0,2,0,2,0,2,2,0,1,1,1,0,0,1,2,0,2,1,0,2,0,1,2,1,1,2,2,2,1};

        int zero = 0;
        int two = arr.length - 1;
        int i = 0;
        int temp;
        while (i <= two) {
            switch (arr[i]) {
                case 0:
                    temp = arr[i];
                    arr[i] = arr[zero];
                    arr[zero] = temp;
                    zero++;
                    i++;
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    temp = arr[i];
                    arr[i] = arr[two];
                    arr[two] = temp;
                    two--;
                    break;

            }

        }
        for (int temp1 : arr) {
            System.out.print(temp1 + " ");
        }


    }
}
