package recursion;

import java.util.ArrayList;
import java.util.List;

public class Example1 {

    static List arr = new ArrayList<Integer>();
    static int n = 6;

    public static void main(String args[]) {


        arr.add(7);
        arr.add(6);
        arr.add(8);
        arr.add(2);
        arr.add(4);
        arr.add(0);

        Example1 e = new Example1();
        e.function1(0, new ArrayList());

    }

    public  void function1(int index, List data) {
        if (index < n) {
            for (int i = index; i < n; i++) {
                List  dummy = new ArrayList(data);
                dummy.add(arr.get(i));
                dummy.forEach((k) -> System.out.print(k + "\t"));
                System.out.println();
                function1(i + 1, dummy);
            }
        }

    }
}
