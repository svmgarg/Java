package hackerearth.expedia;

import java.util.*;


public class Test {

    public static void main(String args[]) {

        // Scanner s = new Scanner(System.in);
        // long num = s.nextLong();
        long num = 25000L;


        int cubic = Math.min((int) Math.cbrt(num) + 1, 1000);
        int sroot = (int) Math.sqrt(num)+1;
        int square = Math.min( sroot, 1000);
        int fourth = Math.min(sroot, 1000);
        int first = (int) Math.min(num, 1000);
        long result = 0;


        for (int i = 0; i <= fourth; i++) {
            long fourthValue = (long) Math.pow(i, 4);
            for (int j = 0; j <= cubic; j++) {
                long thirdValue = (long) Math.pow(j, 3) + fourthValue;
                for (int k = 0; k <= square; k++) {
                    long secondValue = (long) Math.pow(k, 2) + thirdValue;
                    long r =0;
                    if(num - secondValue >=0){
                        result = result + Math.min(num - secondValue, first)+1;
                    }
                }
            }
        }
        System.out.println(result);


    }
}
