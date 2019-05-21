package dataStructure.tree.traversal;

import dataStructure.Node;

public class PostorderTraversal {


    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("\nPost Order : ");
        printPostorder(root);


    }


    static void printPostorder(Node node) {
        if (node != null) {
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.print(node.data + "\t");
        }
    }



}
