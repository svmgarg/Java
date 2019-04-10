package dataStructure.bst;

import dataStructure.Node;

public class BalancedTreeTest {

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
        //Not a balanced binary tree

        if(balancedHeight(root) >0){
            System.out.println("balanced binary tree");
        }else{
            System.out.println("not a balanced binary tree");
        }





        root.right.left.left.left.left = null;
        if(balancedHeight(root) >0){
            System.out.println("balanced binary tree");
        }else{
            System.out.println("not a balanced binary tree");
        }


    }

    public static int balancedHeight(Node node) {

        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }

        int leftheight = balancedHeight(node.left);
        if (leftheight == -1) {
            return -1;
        }
        int rightHeight = balancedHeight(node.right);
        if (rightHeight== -1) {
            return -1;
        }
        if (Math.abs(rightHeight- leftheight) >= 0 && Math.abs(rightHeight- leftheight) <= 1) {
            return Math.max(rightHeight, leftheight)+1;
        } else {
            return -1;
        }

    }


}
