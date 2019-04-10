package algo.longestPalindromeSubstring;


//https://youtu.be/obBdxeCx_Qs
public class LongestPalindromeSubstringTest {

    public static  void main(String args[]){

        String  str = "forgeeksskeegfor";

        boolean[][] mat = new boolean[str.length()][str.length()];

        for(int i=0;i<str.length();i++){
            mat[i][i]=true;
        }
        int start =0;
        int length =1;
        for(int i=0;i<str.length()-1;i++){
            mat[i][i+1] =  str.charAt(i)== str.charAt(i+1);
            if(mat[i][i+1]){
                start = i;
                length++;
            }
        }


        for(int len=3;len<=str.length();len++){
            for(int i=0;i< str.length()-len+1;i++){
                int j =  i+len-1;
                if(str.charAt(i) == str.charAt(j)){
                    mat[i][j] = mat[i+1][j-1];
                    if(mat[i][j] && len> length){
                        start = i;
                        length = len;
                    }
                }else{
                    mat[i][j] = false;
                }
            }
        }

        System.out.println(str.subSequence(start, start+length));

    }
}
