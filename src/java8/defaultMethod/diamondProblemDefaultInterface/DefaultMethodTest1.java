package java8.defaultMethod.diamondProblemDefaultInterface;

/**
 * Redeclare the default method, which makes it abstract.
 */
public class DefaultMethodTest1 {
    public static void main(String args[]) {

    }

    //Interface having default method
    interface MyDefaultInterface {
        default void print(String str) {
            System.out.println("Default Interface => " + str);
        }
    }

    //Interface suppressing default method implementation of parent interface
    interface MyDefaultInterface2 extends MyDefaultInterface {
        void print(String str);
    }

    //child class inheriting the default method implementation of parent interface
    abstract class MyDummyClass implements MyDefaultInterface {
        public void print(String str) {
            System.out.println("Abstract Class => " + str);
        }
    }

    //child class suppressing the default method implementation of parent interface
    abstract class MyDummyClass2 implements MyDefaultInterface2 {
        abstract public void print(String str);
    }


}
