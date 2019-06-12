package dataStructure.tree.traversal;

import dataStructure.tree.Node;

import java.util.LinkedList;

public class LevelorderTraversal {

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int height = height(root);

        System.out.println("\nLevel Order with Recursion : top-down");
        for(int i=1; i<=height;i++){
            levelOrderTraversalUsingRecursion(root, i);
        }

        System.out.println("\nLevel Order with Recursion : bottom-up");
        for(int i=height; i>=1;i--){
            levelOrderTraversalUsingRecursion(root, i);
        }

        System.out.println("\nLevel Order with Queue : ");
        levelOrderTraversalUsingQueue(root);


    }


    static int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int left = height(node.left);
            int right = height(node.right);
            return (left > right ? left : right) + 1;
        }

    }


    static void levelOrderTraversalUsingRecursion(Node node, int height) {

        if (node != null) {
            if (height == 1) {
                System.out.print(node.data+"\t");
            } else {
                levelOrderTraversalUsingRecursion(node.left, height - 1);
                levelOrderTraversalUsingRecursion(node.right, height - 1);
            }
        }

    }


    static void levelOrderTraversalUsingQueue(Node root) {

        LinkedList<Node> list = new LinkedList();
        list.add(root);
        Node temp;
        while (!list.isEmpty()) {
            temp = list.remove(0);
            if (temp != null) {
                System.out.print(temp.data + "\t");
                list.add(temp.left);
                list.add(temp.right);
            }
        }
    }
}