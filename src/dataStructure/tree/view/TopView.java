package dataStructure.tree.view;

import dataStructure.tree.Node;

import java.util.Map;
import java.util.TreeMap;

public class TopView {

    static TreeMap<Integer, Integer> map = new TreeMap();

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
        process(root, 0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

    }

    static void process(Node node, int horizonatalDistance) {
        if (node != null) {
            if (map.get(horizonatalDistance) == null) {
                map.put(horizonatalDistance, node.data);
            }
            process(node.left, horizonatalDistance - 1);
            process(node.right, horizonatalDistance + 1);
        }
    }
}