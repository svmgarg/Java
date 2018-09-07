package callingHierarchy;

/**
 * Assignment conversion while calling methods will go in below order.
 * a)	an identity conversion
 * b)	a widening primitive conversion
 * c)	a widening reference conversion
 * d)	boxing for primitive type
 * e)	unboxing for reference type
 * f)	a boxing conversion optionally followed by a widening reference conversion
 * g)	an unboxing conversion optionally followed by a widening primitive conversion.
 */

public class PrimitiveCalling {

    public static void main(String atrgs[]) {

        /**
         *  This is a typical example of widening
         *  Here it will call function(int) as int is upcoming widen type for byte in below methods
         */

        byte b = 10;
        function(b);

        /**
         *  This is a typical example of "boxing conversion followed by a widening reference conversion"
         *  Here it will call function(Number) as "long" is boxed to "Long" and then widen to supertype "Number".
         */
        long a = 10;
        function(a);
    }

    public static void function(int i) {
        System.out.println("Calling int");
    }

    /*public static void function(long i) {
        System.out.println("Calling long");
    }*/


    public static void function(Byte i) {
        System.out.println("Calling Int");
    }

    public static void function(Number i) {
        System.out.println("Calling Number");
    }

    public static void function(Integer i) {
        System.out.println("Calling Integer");
    }

    /*public static void function(Long i) {
        System.out.println("Calling Long");
    }*/

    public static void function(String i) {
        System.out.println("Calling String");
    }

    public static void function(Object i) {
        System.out.println("Calling Object ");
    }

}
