package dataStructure.tree.lca;

import dataStructure.tree.Node;

public class LCATest {

    public static  void main(String args[]){

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.left = new Node(13);
        root.right.right = new Node(22);



        Node node  = lca(root, 6, 5);
        System.out.println(node.data);



    }

    public static Node lca(Node root, int v1, int v2) {

        if(root == null){
            return null;
        }
        Node temp;

        Node left = lca(root.left, v1, v2);
        Node right = lca(root.right, v1, v2);
        if(left != null && right != null ){
            temp =root;
        }else if(left ==null && right ==null ){
            temp = null;
        }
        if(root.data == v1 || root.data == v2){
            temp = root;
        }else{
            temp = left !=null ? left : right;
        }
    return temp;

    }


}


