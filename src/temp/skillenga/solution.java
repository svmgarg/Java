package temp.skillenga;

import java.util.*;

public class solution {

    public static void main(String args[]) {


        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());
        String[] temp;
        for (int tt = 0; tt < t; tt++) {
            temp = scanner.nextLine().trim().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            temp = scanner.nextLine().trim().split(" ");
                Set<String> map = new HashSet();
                for (String s : temp) {
                    map.add(s);
                }
                temp = scanner.nextLine().trim().split(" ");
                Set<String> map2 = new HashSet();
                for (String s : temp) {
                    map2.add(s);
                }
                Set list = new HashSet();
            switch (Integer.parseInt(scanner.nextLine().trim())) {
                case 1:
                    map.retainAll(map2);
                    list.addAll(map);
                    break;
                case 2:
                    list.addAll(map);
                    list.addAll(map2);
                    break;
                case 3:
                    list.addAll(map);
                    list.addAll(map2);
                    map.retainAll(map2);
                    list.removeAll(map);
                    break;
                case 4:
                    map.removeAll(map2);
                    list.addAll(map);
                    break;
                case 5:
                    map2.removeAll(map);
                    list.addAll(map2);
                    break;

            }

            List sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);
            System.out.println(sortedList.toString().replace("[","{").replace("]","}"));
        }



        /*
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());
        String[] temp;
        for (int tt = 0; tt < t; tt++) {
            temp = scanner.nextLine().trim().split(" ");
            int E = Integer.parseInt(temp[0]);
            int C = Integer.parseInt(temp[1]);
            int D = Integer.parseInt(temp[2]);

            int[][] arrE = new int[E + 1][C];
            for (int ee = 0; ee < E + 1; ee++) {
                temp = scanner.nextLine().trim().split(" ");
                for (int cc = 0; cc < C; cc++) {
                    arrE[ee][cc] = Integer.parseInt(temp[cc]);
                }
            }

            int td = 0;
            int ans = 0;
            for (int ee = 1; ee < E + 1; ee++) {
                td = 0;
                for (int cc = 0; cc < C; cc++) {
                    if (arrE[ee][cc] != arrE[0][cc]) {
                        td = td + 1;
                    }
                }
                if (td <= D) {
                    ans = ans + 1;
                }
            }
            System.out.println(ans);
        }
*/



/*
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        String[] temp;
        for (int tt = 0; tt < t; tt++) {
            temp = sc.nextLine().trim().split(" ");
            int n = Integer.parseInt(temp[0]);
            temp = temp[1].replace("(", "").replace(")", "").split(",");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            int ans = n * n - (2 * (n - 1) + Math.min(n - x, y - 1) + Math.min(n - x, n - y) + Math.min(x - 1, y - 1) + Math.min(x - 1, n - y));
            System.out.println(ans);
        }
*/


       /* Scanner scanner = new Scanner(System.in);
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
            int bright = Integer.parseInt(scanner.nextLine().trim());
            int ans =bright;
            if(n>1){
                ans  =  deepestNode(nodes.get(bright )).data;
            }

            System.out.println(ans);
        }*/

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
