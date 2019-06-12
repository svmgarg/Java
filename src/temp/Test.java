package temp;

import java.util.*;

class IComparator implements Comparator<Integer>{


    public int compare(Integer s1,Integer s2) {
        return Math.abs(s1) - Math.abs(s2);
    }
}

public class Test {

    static int minimumAbsoluteDifference(int[] arr) {
        PriorityQueue<Integer>  queue = new PriorityQueue(10, new IComparator());
        for(int i : arr){
            queue.add(i);
        }
        int last =queue.remove();
        int min  =Integer.MAX_VALUE;
        int temp ;
        for(int i=1;i<arr.length;i++){
            int y = queue.remove();
            temp = Math.abs(y - last);
            last = y;
            if(min > temp){
                min = temp;
            }
        }
        return min;
    }


    public static void main(String args[]) {

        Scanner scanner  =  new Scanner(System.in);
        String[] temp = scanner.nextLine().trim().split(" ");
        int arr[] = new int[temp.length];
        for(int i=0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        minimumAbsoluteDifference(arr);


      /*  Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        s=s.replace(" ", "");
        s=s.replace("-", "");

        int nd = s.length();

        int nr = 0;
        if (nd % 3 == 0) {
            nr = nd + nd / 3 - 1;
        } else {
            nr = nd + nd / 3;
        }
        char[] c = new char[nr];
        for (int i = 0, j = 0; i < nd; ) {
            c[j++] = s.charAt(i++);

            if (i < nd) {
                c[j++] = s.charAt(i++);
            }
            if (i < nd) {
                c[j++] = s.charAt(i++);
                if (j < nr) {
                    c[j++] = '-';
                }

            }
        }

        if(nd%3 ==1){
            char t = c[nr-2];
            c[nr-2] =c[nr-3];
            c[nr-3]=t;
        }
        System.out.println(String.valueOf(c));


*/
    }
}
