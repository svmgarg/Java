package collections.vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class IteratotFailSafeTest {

    public static void main(String[] args) {

        final Vector<Integer> numbers = new Vector<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        // new thread to retriving the numbers
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Iterator e = numbers.iterator();
                    while (e.hasNext()) {
                        System.out.println("Printing Thread : " + e.next());
                        Thread.sleep(150);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        // new thread to concurrently modify the list
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 10; i < 15; i++) {
                        numbers.add(i);
                        //numbers.remove(0);
                        System.out.println("Modifying Thread : " + i);
                        Thread.sleep(150);

                    }
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }
        }).start();


    }
}
