package algo.longestSubarrayWithEqualZeroAndOne;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqualZeroAndOne {

    static int[] arr = {1, 0, 1, 1, 1, 0, 0};

    public static void main(String args[]) {

        int[] temp = new int[arr.length];

        //in cumulative sum keeping one zero at starting
        int[] csum = new int[temp.length + 1];
        csum[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i] == 1 ? arr[i] : -1;
            csum[i + 1] = temp[i] + csum[i];
        }

        HashMap<Integer, Integer> maxHashes = new HashMap<>();
        HashMap<Integer, Integer> minHashes = new HashMap<>();
        for (int i = 0; i < csum.length; i++) {
            maxHashes.put(csum[i], i);
            if (minHashes.get(csum[i]) == null) {
                minHashes.put(csum[i], i);
            }
        }
        int maxLen =-1;
        int start =-1;
        int end =-1;
        for(Map.Entry<Integer, Integer> entry : maxHashes.entrySet()){
            if((entry.getValue() - minHashes.get(entry.getKey() )) > maxLen ){
                maxLen = (entry.getValue() - minHashes.get(entry.getKey() ));
                start = minHashes.get(entry.getKey());
                end = entry.getValue()-1;
            }
        }

        System.out.println("start : " + start + "\nend : " + end);


    }


}
