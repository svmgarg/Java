package java8.functionalInterface;

public class FunctionalInterfaceTest {

    public static void main(String args[]) {

        MyFunctionalInterface f = (str) -> {
            System.out.println("String is  " + str);
        };

    }

    @FunctionalInterface
    interface MyFunctionalInterface {

        void myAbstractMethod(String str);
    }

}

