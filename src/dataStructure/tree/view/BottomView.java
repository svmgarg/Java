package dataStructure.tree.view;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class BottomView {


    static TreeMap<Integer, Integer> map = new TreeMap();

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        root.right.left.left.left = new TreeNode(13);
        root.right.left.left.left.left = new TreeNode(14);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(12);

        root.hd = 0;
        LinkedList<TreeNode> list = new LinkedList();
        list.add(root);
        TreeNode temp;
        while (!list.isEmpty()) {
            temp = list.remove(0);
            map.put(temp.hd, temp.data);
            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                list.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                list.add(temp.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }


    }
}

class TreeNode {

    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }

    int hd;


}