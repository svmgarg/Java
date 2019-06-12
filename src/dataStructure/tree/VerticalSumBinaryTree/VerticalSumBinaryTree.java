package dataStructure.tree.VerticalSumBinaryTree;

import dataStructure.tree.Node;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumBinaryTree {

    public static TreeMap<Integer, Integer> sum = new TreeMap<>();

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(8);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);
        root.right.left.left.left = new Node(13);
        root.right.left.left.left.left = new Node(14);
        root.right.right = new Node(7);
        root.right.right.left = new Node(11);
        root.right.right.right = new Node(12);

        verticalSum(root, 0);
        int verticals = sum.entrySet().size();
        for (Map.Entry entry : sum.entrySet()) {
            System.out.println(((int) entry.getKey() + verticals / 2) + "  " + entry.getValue());
        }

    }

    public static void verticalSum(Node node, int index) {
        if (node != null) {
            sum.put(index, sum.get(index) != null ? sum.get(index) : 0 + node.data);
            verticalSum(node.left, index - 1);
            verticalSum(node.right, index + 1);
        }
    }
}
