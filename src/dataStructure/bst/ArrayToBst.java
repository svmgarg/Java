package dataStructure.bst;

import dataStructure.Node;

public class ArrayToBst {

    static int arr[] = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String args[]) {

        Node node = createBst(0, arr.length - 1);
    }

    public static Node createBst(int start, int end) {
        Node node = null;
        if (start <= end) {
            int mid = (start + end) / 2;
            node = new Node(arr[mid]);
            node.left = createBst(start, mid-1);
            node.right = createBst(mid + 1, end);
        }
        return node;
    }
}
