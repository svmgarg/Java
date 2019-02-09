package collections.copyOnWriteArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest2 {

    public static void main(String args[]){
        final CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5));

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println("Iteration : "+ i );
            if(i == 4){
                /**
                 * Iterator will return a snapshot of list, so this modification is not reflect
                 */
                numbers.add(6);
                System.out.println("Number added :" + numbers);
            }

        }

    }
}
