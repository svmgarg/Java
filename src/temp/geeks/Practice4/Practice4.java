package temp.geeks.Practice4;

public class Practice4 {

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

    }

    class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

}
