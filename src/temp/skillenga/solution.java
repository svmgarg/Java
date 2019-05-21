package temp.skillenga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        Integer t = Integer.parseInt(scanner.nextLine().trim());
        for (int tt = 0; tt < t; tt++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            String[] temp;
            HashMap<Integer, Node> nodes = new HashMap<>();
            int source = 0;
            int end = 0;
            for (int i = 1; i < n; i++) {
                temp = scanner.nextLine().trim().split(" ");
                source = Integer.parseInt(temp[0]);
                end = Integer.parseInt(temp[1]);
                if (nodes.get(source) == null) {
                    nodes.put(source, new Node(source));
                }
                if (nodes.get(end) == null) {
                    nodes.put(end, new Node(end));
                    nodes.get(source).childs.add(nodes.get(end));
                }
            }
            System.out.println(deepestNode(nodes.get(Integer.parseInt(scanner.nextLine().trim()))).data);
        }

    }


    static Node deepestNode(Node node) {
        if (isLeaf(node)) {
            //node.height = node.height + 1;
            return node;
        }

        Node deep = null;
        int height = 0;
        Node temp;

        for (Node child : node.childs) {
            child.height = node.height + 1;
            temp = deepestNode(child);
            if (temp.height > height) {
                height = temp.height;
                deep = temp;
            }
        }
        return deep;

    }

    static boolean isLeaf(Node node) {
        return node.childs.isEmpty();
    }
}


class Node {

    int data;
    List<Node> childs;
    int height;

    Node(int data) {
        this.data = data;
        this.childs = new ArrayList<>();
    }

}
