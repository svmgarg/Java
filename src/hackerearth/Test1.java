package hackerearth;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
        public static  void  main(String args[]){
            Scanner s = new Scanner(System.in);
            int n = Integer.parseInt(s.nextLine());


            for(int i =0  ; i < n;i++){
                int t = s.nextInt();
                String arrS  = s.nextLine();
                String arrC = arrS.replace(" " ,"");
                int zero =0;
                for(char c : arrC.toCharArray()){
                    if(c=='0'){
                        zero = zero +1;
                    }
                }
                int one = t -zero;
                if(one %3 !=0){
                    System.out.println("-1");
                }else{

                    int factor = one /3;
                    int analysed =0 ;
                    int pointer=0;
                    for(pointer = arrC.length()-1  ; i >=0 ; i-- ){
                        if(arrC.charAt(pointer)=='1'){
                            analysed = analysed+1;
                            if(analysed == factor){
                                break;
                            }
                        }
                    }
                    String requiredString = arrC.substring( pointer, arrC.length());
                    String remString = arrC.substring( 0, pointer);
                    Pattern pattern = Pattern.compile(requiredString);
                    Matcher matcher = pattern.matcher(remString);
                    int from = 0;
                    int count = 0;
                    while(matcher.find(from)) {
                        count++;
                        from = matcher.start() + 1;
                    }
                    if(count ==2){
                        System.out.println(Integer.parseInt(requiredString)%1000000007);
                    }else{
                        System.out.println("-1");
                    }

                }
            }
        }
}
