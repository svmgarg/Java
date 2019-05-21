package dataStructure.tree.maximumWidth;

import dataStructure.Node;

import java.util.LinkedList;
import java.util.List;

public class MaximumWidth {

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

        List<Node> list = new LinkedList();


        list.add(root);
        int maxWidth = 0;
        int i = 0;
        List<Node> temp;
        while (!list.isEmpty()) {
            if (maxWidth < list.size()) {
                maxWidth = list.size();
            }
            temp = new LinkedList<>();
            i = 0;
            while (i < list.size()) {
                Node node = list.remove(0);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
                i++;
            }
            list.addAll(temp);
        }
        System.out.println(maxWidth);

    }
}
