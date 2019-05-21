package dataStructure.tree.view;

import dataStructure.Node;

import java.util.LinkedList;

public class LeftView {
    static Node root;

    public static void main(String args[]) {

        root = new Node(1);
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

        approach1();
        System.out.println();



        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        approach2();
    }

    public static void approach2() {
        LinkedList<Node> list = new LinkedList<>();
        list.add(null);
        list.add(root);
        Node temp;
        while (!list.isEmpty()) {
            temp = list.remove(0);
            if (temp != null) {
                if (temp.left != null) {
                    list.add(temp.left);
                }
                if (temp.right != null) {
                    list.add(temp.right);
                }
            } else {
                if (!list.isEmpty()) {
                    System.out.print(list.get(0).data);
                    list.add(null);
                }
            }
        }
    }


    public static void approach1() {
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        list.add(null);
        System.out.print(root.data + " ");
        Node temp;
        while (!list.isEmpty()) {
            temp = list.remove(0);
            if (temp != null) {
                if (temp.left != null) {
                    list.add(temp.left);
                }
                if (temp.right != null) {
                    list.add(temp.right);
                }
            } else {
                if (!list.isEmpty()) {
                    System.out.print(list.get(0).data + " ");
                    list.add(null);
                }
            }
        }
    }

}
