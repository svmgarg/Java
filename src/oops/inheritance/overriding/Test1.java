package oops.inheritance.overriding;

import java.io.IOException;

public class Test1 {

    public static  void main(String args[]){


    }



}

/**
 * If child method throw checkde exception then it should be narrow
 *
 * It might possible parent method throw exception but child method doesn't throw exception
 */
class A{

    void function() throws IOException {
    }
}

class B extends  A{

    @Override
    void function() {
    }
}