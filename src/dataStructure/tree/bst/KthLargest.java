package dataStructure.tree.bst;

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class KthLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = new Node(sc.nextInt());
            for (int i = 0; i < n - 1; i++)
                insert(root, sc.nextInt());
            int k = sc.nextInt();
            GfG g = new GfG();
            g.kthLargest(root, k);
        }
    }

    public static Node insert(Node root, int n) {
        if (root == null)
            return new Node(n);
        if (n < root.data)
            root.left = insert(root.left, n);
        if (n > root.data)
            root.right = insert(root.right, n);
        return root;
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below
The Node is as follows
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=null;
		right=null;
	}
}
*/
class Data {
    public int index;
    public int val;
}

class GfG {
    public void kthLargest(Node root, int k) {

        int val = find(new Data(), root, k).val;
        System.out.println(val);
    }


    static Data find(Data d, Node node, int k) {
        if (node.left == null && node.right == null) {
            d.index = d.index + 1;
            if(d.index ==k){
                d.val =node.data;
            }
            return d;
        }
        if (node.right != null) {
            d = find(d, node.right, k);
        }
        d.index = d.index + 1;
        if (d.index == k) {
            d.val = node.data;
        }


        if (node.left != null) {
            d = find(d, node.left, k);
        }

        return d;
    }
}