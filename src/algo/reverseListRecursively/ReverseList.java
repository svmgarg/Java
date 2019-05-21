package algo.reverseListRecursively;

public class ReverseList {

    static Node start;

    public static void main(String args[]) {

        start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);
        start.next.next.next.next.next = new Node(6);
        start.next.next.next.next.next.next = new Node(7);

        reverse(start);

        Node temp = start;
        while (temp.next != null) {

            System.out.println(temp.data);
            temp = temp.next;

        }
        System.out.println(temp.data);

    }

    static Node reverse(Node node) {

        if (node.next == null) {
            start = node;
        } else {
            reverse(node.next);
            node.next.next = node;
            node.next = null;
        }
        return node;
    }

}


class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}