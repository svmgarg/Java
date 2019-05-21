package dataStructure.tree.mirror;

import dataStructure.Node;

public class MirrorTest {


    public static void main(String args[]) {

        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);

        System.out.println(isMirror(a, b));
    }


    public static boolean isMirror(Node a, Node b) {

        if (a == null && b == null) {
            return true;
        }else if (a==null ||  b==null){
            return false;
        }
        return a.data == b.data && isMirror(a.right, b.left) && isMirror(a.left, b.right);

    }


}
