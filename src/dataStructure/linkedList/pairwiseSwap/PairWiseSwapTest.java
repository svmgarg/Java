package dataStructure.linkedList.pairwiseSwap;

import dataStructure.linkedList.Node;

public class PairWiseSwapTest {

    public static Node head;

    public static void main(String args[]) {
        int[] d = {18,5 ,11 ,30 ,5 ,19, 19, 23, 15, 6 ,6 ,2};
        head = new Node(18);
        Node node = head;
        for(int i=1;i <d.length;i++){
            node.next = new Node(d[i]);
            node=  node.next;
        }
        pairwiseSwap(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }

    public static void pairwiseSwap(Node node) {
        head = swap(node);
    }

    public static Node swap(Node node) {
        if (node != null && node.next != null) {
            Node temp = node.next;
            Node nxt = temp.next;
            temp.next = node;
            node.next = swap(nxt);
            node = temp;
        }
        return node;
    }

}
