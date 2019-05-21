package dataStructure.tree.view;

import dataStructure.Node;

import java.util.LinkedList;

public class RightView {


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


        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        list.add(null);
        int last = -1;
        Node temp;
        while (!list.isEmpty()) {
            temp = list.remove(0);
            if (temp != null) {
                last = temp.data;
                if (temp.left != null) {
                    list.add(temp.left);
                }
                if (temp.right != null) {
                    list.add(temp.right);
                }

            } else {
                System.out.print(last + " ");
                if (!list.isEmpty()) {
                    list.add(null);
                }
            }

        }


    }
}
