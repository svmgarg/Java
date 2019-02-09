package java8.optional;

import java.util.List;
import java.util.Optional;

public class Test1 {
    public static void main(String args[]){
       Object s = null;

       Optional a  = Optional.of((List)s );
    }
}
