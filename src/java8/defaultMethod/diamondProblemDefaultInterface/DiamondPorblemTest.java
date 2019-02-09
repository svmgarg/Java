package java8.defaultMethod.diamondProblemDefaultInterface;

public class DiamondPorblemTest {
    public static void main(String args[]) {

        DiamondPorblemTest object = new DiamondPorblemTest();

        DiamondPorblemTest.ChildClass chld = object.new ChildClass();
        chld.print("");
    }

    interface MyDefaultInterface {
        default void print(String str) {
            System.out.println("Default Interface => " + str);
        }
    }

    interface MyDefaultInterface2 {
        default void print(String str) {
            System.out.println("Default Interface => " + str);
        }
    }

    class MyDummyClass {
        public void print(String str) {
            System.out.println("My Dummy Class  => " + str);
        }
    }

    class ChildClass extends MyDummyClass implements MyDefaultInterface, MyDefaultInterface2 {
        public void print(String str) {
            MyDefaultInterface.super.print("shivam");
            MyDefaultInterface2.super.print("shivam");
            super.print("shivam");
        }
    }
}
