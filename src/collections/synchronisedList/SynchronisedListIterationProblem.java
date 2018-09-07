package collections.synchronisedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * In the below code, Main Thread is creating two threads Thread -1 and Thread -2
 *
 * Main Thread will be responsible for iterating the Collections.synchronisedList
 * Thread -1 will be adding even numbers to  Collections.synchronisedList  to list
 * Thread -2 will be adding odd numbers to  Collections.synchronisedList  to list
 *
 * In the below code we will be getting "ConcurrentModificationException" .
 *       1) The Collections.synchronizedList only means that add, remove etc. operations are synchronized and therefore atomic.
 *          for-loop/Iteration however is not and if a thread adds while another is iterating, you could get a ConcurrentModificationException.
 *       2) To avoid such situation we should iterate the Collections.synchronisedList in a synchronised context
 */
public class SynchronisedListIterationProblem {
    public static void main(String[] args) throws InterruptedException {

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


        System.out.println("Main Thread is iterating the numbers list without synchronised context, so 'ConcurrentModificationException' will come \n");
        for (int i : numbers) {
            System.out.print(i + "\t");
            try {
                Thread.sleep(15);
            } catch (InterruptedException ie) {

            }
        }
        System.out.println("numbers : " + numbers);

    }
}