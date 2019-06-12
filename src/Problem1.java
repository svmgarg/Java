import java.util.Scanner;

public class Problem1 {

    static int[]  alphabhets;
    static int n;
    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();                 // Reading input from STDIN
        n = s.nextInt();
        char[] charArray = str.toCharArray();
        alphabhets = new int[26];

        for(int i = 0 ; i < n; i ++){
            alphabhets[charArray[i]-97] = alphabhets[charArray[i]-97]+1;
        }
        for(int i = n;i< charArray.length;i++){
            int element = getfirstElement();
            if(element >=0){
                alphabhets[element] = alphabhets[element]-1;
                System.out.print((char)(element+97));
                alphabhets[charArray[i]-97] = alphabhets[charArray[i]-97]+1;
                //hackerearth
            }
        }

        for(int i = 0 ; i < n; i ++){
            int element  = getfirstElement();
            alphabhets[element] = alphabhets[element]-1;
            System.out.print((char)(element+97));
        }

    }

    static int getfirstElement(){
        for(int i =0;i < 26;i++){
            if(alphabhets[i] >0 ){
                return i;
            }
        }
        return -1;
    }
}