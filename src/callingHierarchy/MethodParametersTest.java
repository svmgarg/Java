package callingHierarchy;

public class MethodParametersTest {

    public static void main(String args[]){

        MethodParametersTest obj = new MethodParametersTest();
        //obj.integerMethod(Long.valueOf(10L));
        //obj.integerMethod(Short.valueOf("10"));
        //obj.longMethod(10);
        obj.method(10);
    }

    public void method(Integer i){
        System.out.println("intger");
    }

    public void method(long i){
        System.out.println("long");
    }
    public void method(Long i){

    }

    public void method(Number i){

    }


}

