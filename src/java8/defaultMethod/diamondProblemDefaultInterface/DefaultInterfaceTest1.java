package java8.defaultMethod.diamondProblemDefaultInterface;

public class DefaultInterfaceTest1 {
    public static void main(String args[]){
        DefaultInterfaceTest1 object = new DefaultInterfaceTest1();
        DefaultInterfaceTest1.Child child = object.new Child();
        child.myMethod();

    }
    interface Parent{
        default  void myMethod(){
            System.out.println("Defalut Method");
        }
    }
    class Child implements  Parent{

    }

}
