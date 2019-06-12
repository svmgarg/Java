package temp.geeks.Practice3;

public class Practice3 {

    public static void main(String args[]) {

        int k = 4;
        int[] s = {10, 11, 12, 13, 14, 16, 4};

        System.out.println(searchinRotatedArray(s, k));


    }


    public static int searchinRotatedArray(int[] arr, int k) {

        int start = 0;
        int end = arr.length - 1;

        int mid;
        while (start != end ) {
            mid = (start + end) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[start] <= arr[mid]) {
                if (k >= arr[start] && arr[mid] > k) {
                    end = mid - 1;
                } else {
                    start = mid+1;
                }
            } else {
                if (arr[mid] < k) {
                    start = mid+1;
                } else {
                    end = mid;
                }
            }


        }
        if(arr[start]==k){
            return start;
        }
        return -1;
    }


}
