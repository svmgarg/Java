package temp.geeks.Practice5;

/**
 * Count number of occurrences (or frequency) in a sorted array
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn)
 */
public class Practice5 {

    public static void main(String args[]) {


        int arr[] = {1, 2, 3, 4, 4, 4,4, 4, 4, 4, 4, 5, 5, 7, 7, 8};

        int k = 4;

        int start = 0;
        int end = arr.length - 1;
        int left=-1;
        while (start <= end) {
            left = (start + end) / 2;
            if (arr[left] < k) {
                start = left + 1;
            } else if (arr[left] > k) {
                end = left - 1;
            }else  if ((left - 1) >= 0 && arr[left - 1] < k) {
                break;
            } else {
                end = left - 1;
            }
        }
        start=0;
        end=arr.length-1;
        int right=-1;
        while (start <= end) {
            right = (start + end) / 2;
            if (arr[right] < k) {
                start = right + 1;
            } else if (arr[right] > k) {
                end = right - 1;
            }else  if ((right+1) <arr.length  && arr[right+1] > k) {
                break;
            } else {
                start = right+1;
            }
        }
        System.out.println(right-left+1);

    }


}
