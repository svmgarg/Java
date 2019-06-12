package dataStructure.tree.sumtree;

import dataStructure.tree.Node;

public class SumTreeTest {

    public static void main(String args[]) {

        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(1);
        root.right.right = new Node(2);


        System.out.println(checkSumTree(root));
    }

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static boolean checkSumTree(Node node) {
        if (isLeaf(node)) {
            return true;
        } else {

            int ls = 0;
            if (node.left != null) {
                if (isLeaf(node.right)) {
                    ls = node.left.data;
                } else {
                    ls = node.left.data * 2;
                }
            }

            int rs = 0;
            if (node.right != null) {
                if (isLeaf(node.right)) {
                    rs = node.right.data;
                } else {
                    rs = node.right.data * 2;
                }
            }

            return node.data == (ls + rs);

        }
    }


}
