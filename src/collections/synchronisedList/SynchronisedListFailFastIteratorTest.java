package collections.synchronisedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronisedListFailFastIteratorTest {

    public static void main(String args[]) throws InterruptedException {

        List<Integer> numbers = Collections.synchronizedList(new ArrayList<Integer>());

        // new thread that will continuously adding even numbers to  the list
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread -1 is adding even numbers to  the numbers list ");
                int i = 0;
                while (i < 1000) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ie) {
                    }
                    numbers.add(i * 2);
                    i++;
                }
            }
        }).start();

        // new thread that will continuously adding odd numbers to  the list
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread -2 is adding odd numbers to  the numbers list ");
                int i = 0;
                while (i < 1000) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ie) {
                    }
                    numbers.add(i * 2 + 1);
                    i++;
                }
            }
        }).start();


        Thread.sleep(1000);


        System.out.println("Main Thread is iterating the numbers list in synchronised context \n");
        Iterator iter = numbers.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + "\t");
            try {
                Thread.sleep(15);
            } catch (InterruptedException ie) {

            }
        }



    }
}
