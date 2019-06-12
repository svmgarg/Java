package temp.geeks;

import java.util.Scanner;

public class Problem6 {

    public static void main(String args[]) {


        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int ii = 0; ii < t; ii++) {
            int n = scanner.nextInt();
            int ans  =0;
            int nk=0;
            for (int k = 1; k <= n; k++) {
                nk =  n/k;
                ans = ans +  nk* ( n*2-nk);
            }
            System.out.println(ans);

            ans =0;
            System.out.println("Naive");
            for(int  i=1;i<=n;i++){
                for(int j =1;j<= n;j++){
                    for(int k=1;k<=n;k++){
                        if((i*j) %k ==0){
                            System.out.println(k);
                            ans = ans +1;
                        }
                    }
                }
            }
            System.out.println(ans);


        }
    }
}
