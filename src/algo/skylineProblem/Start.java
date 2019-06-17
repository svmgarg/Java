package algo.skylineProblem;

import java.util.*;
import java.util.stream.Stream;

public class Start {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] input = new int[n][];
        for (int i = 0; i < n; i++) {
            input[i] = Stream.of(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        List<List<Integer>> ans = new Solution().getSkyline(input);
        for (List<Integer> l : ans) {
            System.out.println(l.get(0) + " " + l.get(1));
        }
    }

}

class Solution {

    class Coordinates implements Comparable<Coordinates> {

        public int x;
        public int h;
        public boolean start;

        public Coordinates(int x, int h, boolean start) {
            this.x = x;
            this.h = h;
            this.start = start;
        }

        public int compareTo(Coordinates c) {
            if (this.x != c.x) {
                return this.x - c.x;
            } else {
                if (this.start != c.start) {
                    if (this.start) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    if (this.start) {
                        return c.h - this.h;
                    } else {
                        return this.x - c.x;
                    }
                }
            }

        }


    }

    public List<List<Integer>> getSkyline(int[][] buildings) {

        PriorityQueue<Coordinates> c = new PriorityQueue<Coordinates>();
        for (int[] b : buildings) {
            c.add(new Coordinates(b[0], b[2], true));
            c.add(new Coordinates(b[1], b[2], false));
        }


        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        Coordinates temp;
        List<List<Integer>> ans = new ArrayList<>();

        while (!c.isEmpty()) {
            temp = c.remove();
            if (temp.start) {
                if (queue.peek() == null || queue.peek() < temp.h) {
                    List l = new ArrayList<Integer>();
                    l.add(temp.x);
                    l.add(temp.h);
                    ans.add(l);
                }
                queue.add(temp.h);
            } else {
                int curr = queue.peek();
                queue.remove(temp.h);
                if (queue.peek() == null || queue.peek() != curr) {
                    List l = new ArrayList<Integer>();
                    l.add(temp.x);
                    l.add(queue.peek() != null ? queue.peek() : 0);
                    ans.add(l);
                }
            }
        }

        return ans;

    }


}