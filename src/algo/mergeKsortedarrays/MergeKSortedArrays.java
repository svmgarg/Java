package algo.mergeKsortedarrays;

import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String args[]) {
        int[][] arrays = {{0, 1, 2, 3, 4}, {2, 3, 5},{8,9,10}};
        int[] sorted = mergeAndsort(arrays);

        for (int a : sorted          ) {
            System.out.print(a+"\t");
        }

    }

    static class Node implements Comparable<Node> {
        int value;
        int index;
        int arrayIndex;

        public Node(int value, int index, int arr) {
            this.value = value;
            this.index = index;
            this.arrayIndex = arr;
        }

        @Override
        public int compareTo(Node o) {
            if (o != null) {
                return this.value - o.value;
            }
            return 1;
        }
    }


    public static int[] mergeAndsort(int[][] arrays) {
        int length = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>();

        for (int i = 0; i < arrays.length; i++) {
            length = length + arrays[i].length;
            if (arrays[i].length > 0) {
                queue.add(new Node(arrays[i][0], 0, i));
            }
        }
        int sorted[] = new int[length];
        Node temp;
        for (int i = 0; i < sorted.length; i++) {
            temp = queue.poll();
            sorted[i] = temp.value;
            if (temp.index + 1 < arrays[temp.arrayIndex].length) {
                queue.add(new Node(arrays[temp.arrayIndex][temp.index + 1], temp.index + 1, temp.arrayIndex));
            }
        }

        return sorted;
    }

}
