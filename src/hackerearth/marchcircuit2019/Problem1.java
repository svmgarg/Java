package hackerearth.marchcircuit2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem1 {


    public static void main(String args[]) {


        Scanner scanner = new Scanner(System.in);
        scanner.nextLine().trim().split(" ");
        String[] str = scanner.nextLine().trim().split(" ");
        ArrayList diff = new ArrayList();
        for(int i = 1;i< str.length;i++){
            diff.add(Integer.parseInt(str[i])-Integer.parseInt(str[i-1]));
        }
        int max = (int) Collections.max(diff);


        str = scanner.nextLine().trim().split(" ");

        int ans =0;
        for(String s : str){
            if(Integer.parseInt(s) <= max){
            ans++;
            }
        }
        System.out.println(ans);



    }


}
