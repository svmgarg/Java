package dataStructure.tree.traversal;

import dataStructure.Node;

import java.util.Stack;

public class SpiralTraversal {

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("\nSpiral Order with Queue: ");
        spiralOrderTraversalUsingQueue(root);


    }

    static void spiralOrderTraversalUsingQueue(Node root) {

        Stack<Node> left = new Stack();
        Stack<Node> right = new Stack();
        left.add(root);
        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.isEmpty()) {
                while (!right.isEmpty()) {
                    Node node = right.pop();
                    if (node != null) {
                        System.out.print(node.data + "\t");

                        left.add(node.right);
                        left.add(node.left);
                    }
                }
            } else {
                while (!left.isEmpty()) {
                    Node node = left.pop();
                    if (node != null) {
                        System.out.print(node.data + "\t");
                        right.add(node.left);
                        right.add(node.right);
                    }
                }
            }
        }
    }

}
