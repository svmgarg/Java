package temp.leetcode;

import java.util.*;
import java.util.stream.Stream;

public class Test {


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().split(" ");
        int[] arr = Stream.of(str).mapToInt(Integer::parseInt).toArray();
        Solution sol = new Solution();
        sol.threeSum(arr);

    }
}

class Solution {
    class Triplets {
        public int a, b, c;

        Triplets(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            Triplets t = (Triplets) obj;
            return this.a == t.a && this.b == t.b && this.c == t.c;
        }

        public int hashCode() {
            return this.a + this.b + this.c;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Triplets> ans = new HashSet<Triplets>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] == 0) {
                    Triplets t = new Triplets(nums[l], nums[r], nums[i]);
                    ans.add(t);
                    l++;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        List<List<Integer>> f = new ArrayList<List<Integer>>();

        for (Triplets t : ans) {
            List<Integer> list = new ArrayList<>();
            list.add(t.a);
            list.add(t.b);
            list.add(t.c);
            f.add(list);
        }

        return f;


    }
}
