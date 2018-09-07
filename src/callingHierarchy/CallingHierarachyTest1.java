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

public class CallingHierarachyTest1 {

    public static void main(String atrgs[]) {

        /**
         * Here in the declared method's method(regularEmployee) is the method having more specific type
         * so it will be called.
         */
        method(null);

    }

    public static void method(RegualarEmployee regualarEmployee) {
        System.out.println("Regular Employee");
    }

    public static void method(Employee employee) {
        System.out.println("Employee");
    }

    class Employee {
    }

    interface Person{
    }

    class RegualarEmployee extends Employee implements  Person {
    }
}
