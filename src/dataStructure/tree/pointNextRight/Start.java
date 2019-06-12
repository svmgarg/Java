package dataStructure.tree.pointNextRight;

import java.util.HashMap;
import java.util.Scanner;



class GfG {
    void connect(Node node) {
        if (node != null) {
            while (node != null) {
                Node temp = node;
                while (temp != null) {
                    if (temp.left != null) {
                        if (temp.right != null) {
                            temp.left.nextRight = temp.right;
                        } else {
                            temp.left.nextRight = getNextRight(temp);
                        }
                    }
                    if (temp.right != null) {
                        temp.right.nextRight = getNextRight(temp);
                    }
                    temp = temp.nextRight;
                }
                if (node.left != null) {
                    node = node.left;
                } else if (node.right != null) {
                    node = node.right;
                } else {
                    node = getNextRight(node);
                }
            }
        }

    }

    Node getNextRight(Node temp) {
        temp = temp.nextRight;
        while (temp != null) {
            if (temp.left != null) {
                return temp.left;
            } else if (temp.right != null) {
                return temp.right;
            } else {
                temp = temp.nextRight;
            }
        }
        return null;
    }
}





public class Start {

    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);

    }

    void printSpecial(Node root) {
        if (root == null)
            return;
        Node node = root;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.nextRight;
        }
        if (root.left != null)
            printSpecial(root.left);
        else
            printSpecial(root.right);

    }


    // driver function to test the above functions
    public static void main(String args[]) {

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Start can = new Start();
        //Node root=null;

        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            GfG g = new GfG();

            g.connect(root);
            can.printSpecial(root);
            System.out.println();
            can.inorder(root);
            System.out.println();
            t--;

        }
    }
}


class Node {
    int data;
    Node left, right, nextRight;

    Node(int item) {
        data = item;
        left = right = nextRight = null;

    }
}


