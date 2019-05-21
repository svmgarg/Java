package dataStructure.tree.bst;

import dataStructure.Node;

public class BinarySearchTreeTest {

    public static void main(String args[]) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.left = new Node(13);
        root.right.right = new Node(22);
        System.out.println(isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    public static boolean isBst(Node node, int min, int max) {

        if (node == null) {
            return true;
        } else {
            boolean flag = node.data > min && node.data < max;
            boolean left = true;
            if (node.left != null) {
                left = isBst(node.left, min, node.data);
            }
            boolean right = true;
            if (node.right != null) {
                right = isBst(node.right, node.data, max);
            }

            return flag && left && right;
        }
    }


}
