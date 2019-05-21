package algo.activitySelection;

//For activity selection  problems
//first fort on the basis of finish time.
public class Test {

    static int n = 6;

    static int s[] = {1, 3, 2, 5, 8, 5};
    static int e[] = {2, 4, 6, 7, 9, 9};

    public static void main(String args[]) {


        int ans = 1;
        int lastActivityFinishTime =  e[0];
        for (int i = 1; i < n; i++) {
            if(lastActivityFinishTime <= s[i]){
                ans = ans +1;
                lastActivityFinishTime =  e[i];
            }
        }
        System.out.println(ans);


    }
}
