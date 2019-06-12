package exception.runtime;

public class RuntTimeExceptionTest {

    public static void main(String[] args){

    }

    class Parent{

        public void getName() throws NullPointerException {

        }
    }

    class Child extends  Parent{
        @Override
        public void getName() throws NullPointerException {
            super.getName();
        }
    }

}
