package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ReflectionTest1 {

    public static void main(String args[]) {

        Test object = new Test("private", "public");

        System.out.println("::::: Reflection started :::::");
        System.out.println(" Class is :: " + object.getClass().getName());
        System.out.println("Constructors are ::");
        for(Constructor constructor : object.getClass().getDeclaredConstructors()){
            System.out.print(constructor.getName() + " :: " );
            for(Parameter parameter: constructor.getParameters()){
                System.out.print(parameter.getType() +" :: " + parameter.getName());
            }
            System.out.println();
        }
        try {
            System.out.println(object.getClass().getDeclaredConstructor(String.class, String.class).newInstance("hi","hi"));
            System.out.println(object.getClass().getDeclaredConstructor(Integer.TYPE).newInstance(10));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        Runtime.getRuntime().gc();
    }
}

class Test {

    private String privateField;
    public String publicField;

    private Test() {
        System.out.println("private constructor");
    }

    public Test(String privateField, String publicFiled) {
        this.privateField = privateField;
        this.publicField = publicFiled;
    }
    Test(String publicFiled) {
        this.publicField = publicFiled;
    }
    protected Test(int publicFiled) {

    }

    public double publicMethod() {
        System.out.println("Public Method");
        return Math.random();
    }

    private double privateMethod() {
        System.out.println("private Method");
        return Math.random();
    }

}
class Test1{

}