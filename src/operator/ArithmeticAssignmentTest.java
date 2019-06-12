package operator;

public class ArithmeticAssignmentTest {

    public static void main(String args[]) {

        double a = 20.30;
        int b = 30;
        System.out.println(b += a);

        a = 20.30;
        b = 30;
//        double c = a + b;
        //int d = (int) (a + b);
        System.out.print(a + b);


        short s =1;
        s = (short) (s+1);
        s++;


        s=+1;
        s+=1;
    }
}
