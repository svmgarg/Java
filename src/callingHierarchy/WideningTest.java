package callingHierarchy;

public class WideningTest {

    public static void main(String args[]){
        //sum(10,new Integer(10));
    }

    /**
     * 1st  argument matched
     * will unbox  2nd argument
     * Then this method will be eligible for calling
     * @param a
     * @param b
     */
    public static  void sum(int a , int b){
    }

    /**
     * 1st argument boxing conversion followed by a widening reference conversion
     * 2nd argument widening reference conversion
     * Then this method will be eligible for calling
     * @param a
     * @param b
     */
    public static  void sum(Number a, Number b){
    }
}
