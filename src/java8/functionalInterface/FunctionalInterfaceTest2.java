package java8.functionalInterface;

import jdk.nashorn.internal.objects.annotations.Function;

public class FunctionalInterfaceTest2 {

    public static void main(String args[]){

    }

    protected native Object clone2() throws CloneNotSupportedException;

    @FunctionalInterface
    interface ParentInterface{


        void parentMethod();
    }

/*    @FunctionalInterface
    interface ChildInterface extends  ParentInterface{

        void childMethod();
    }*/

}
