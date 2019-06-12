package hackerearth.julyCircuit2018;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Problem1 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i =0; i < n; i++){
            int N = s.nextInt();
            int A = s.nextInt();
            int B = s.nextInt();
            long Y  = Math.round ((long)A * N /(float)(A+B));
            long X = N-Y;
            System.out.println(B*Y*Y + A*X*X);
            LinkedHashMap m =  new LinkedHashMap();
            m.put("sd", "sdf");
        }
    }
}
