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

public class CallingHierarachyTest2 {

    public static void main(String atrgs[]) {

        /**
         * Here in the both method(Employee) and method(Person) are eligible for calling
         * hence creating ambiguity so in below calling ambiguity error we will be facing.
         */
        RegualarEmployee regualarEmployee = new RegualarEmployee();
        //method(regualarEmployee);

    }


    public static void method(Employee employee) {
        System.out.println("Employee");
    }

    public static void method(Person person) {
        System.out.println("Person");
    }

}

class Employee {
}

interface Person {
}

class RegualarEmployee extends Employee implements Person {
}