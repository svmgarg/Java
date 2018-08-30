package passByValueOrReference;

public class PassByValueOrReferenceTest {

    public static void main(String args[]) {
        PassByValueOrReferenceTest object = new PassByValueOrReferenceTest();
        PassByValueOrReferenceTest.MyObject myObject = object.new MyObject(5);
        object.increment(myObject);
        /**
         * It should print 10 as passed object was modified in increment object function
         */
        System.out.println(myObject.data);
    }

    /**
     * Passing object reference as value
     * In the below function we got the reference and in that reference object we have modified the data value to 10
     * and after that we have assigned the new "MyObject object" to object with data  20
     */

    protected void increment(MyObject object) {
        System.out.println(object.data);
        object.data = 10;
        object = new MyObject(20);
    }

    class MyObject {
        int data;
        MyObject(int data) {
            this.data = data;
        }
    }

}

