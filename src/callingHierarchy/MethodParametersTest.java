package callingHierarchy;

public class MethodParametersTest {

    public static void main(String args[]){

        MethodParametersTest obj = new MethodParametersTest();
        //obj.integerMethod(Long.valueOf(10L));
        //obj.integerMethod(Short.valueOf("10"));
        //obj.longMethod(10);
        obj.numberMethod(10);
    }

    public void integerMethod(Integer i){

    }

    public void longMethod(Long i){

    }

    public void numberMethod(Number i){

    }


}

