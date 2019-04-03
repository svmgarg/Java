package collections.copyOnWriteArrayList;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnwriteArrayList3 {

    public static void main(String args[]){

        final CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5));

        new Thread(()->{

        });

    }
}
