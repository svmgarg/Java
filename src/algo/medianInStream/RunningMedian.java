package algo.medianInStream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    static int[] arr = {5, 3, 7, 22, 6, 9, 10, 13, 8, 23, 16, 1, 5, 18};

    public static void main(String args[]) {

        for(int a : arr){
            System.out.println(median(a));
        }

    }

    static PriorityQueue<Integer> leftHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -1 * o1.compareTo(o2);
        }
    });
    static PriorityQueue<Integer> rightHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return  o1.compareTo(o2);
        }
    });

    public static int median(int value) {

        if (leftHeap.isEmpty() && rightHeap.isEmpty()) {
            leftHeap.add(value);
            return value;
        } else {
            if (value > leftHeap.peek()) {
                rightHeap.add(value);
            } else {
                leftHeap.add(value);
            }

            if (Math.abs(leftHeap.size() - rightHeap.size()) >= 2) {
                if ((leftHeap.size() - rightHeap.size()) > 0) {
                    rightHeap.add(leftHeap.poll());
                } else {
                    leftHeap.add(rightHeap.poll());
                }
            }

            if ((leftHeap.size() + rightHeap.size()) % 2 == 0) {
                return (leftHeap.peek() + rightHeap.peek()) / 2;
            } else {
                return (leftHeap.size() - rightHeap.size()) > 0 ? leftHeap.peek() : rightHeap.peek();
            }


        }

    }

}
