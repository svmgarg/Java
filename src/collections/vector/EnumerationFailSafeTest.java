package collections.vector;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class EnumerationFailSafeTest {

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
                    Enumeration e = numbers.elements();
                    while (e.hasMoreElements()) {
                        System.out.println("Printing Thread : " + e.nextElement());
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
