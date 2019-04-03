package collections.blockingQueue.arrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * The peek() method retrieves the value of the first element of the queue without removing it from the queue.
 * For each invocation of the method, we always get the same value and its execution does not affect the size of the queue.
 * If the queue is empty the peek() method returns null.
 *
 * The element() method behaves like peek(), so it again retrieves the value of the first element without removing it.
 * Unlike peek, if the list is empty element() throws a NoSuchElementException
 *
 *
 *
 * The poll() method retrieves the value of the first element of the queue by removing it from the queue.
 * At each invocation it removes the first element of the list and if the list is already empty it returns null
 * but does not throw any exception
 *
 * The remove() method behaves as the poll() method, so it removes the first element of the list
 * and if the list is empty it throws a NoSuchElementException
 *
 *
 *
 * The take() method is thread safe method, if queue is empty then
 */
public class ArrayBlockingQueueTest {

    public static void main(String args[]) throws InterruptedException {

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(10);

        /*
        Thread used to peek in blocking queue.
        */
        Thread peek = new Thread(() -> {
            System.out.println("Peek started");
            System.out.println(arrayBlockingQueue.peek());
            System.out.println("Peek Finished, Null response");
        });
        peek.start();

        /*
        Thread used to poll in blocking queue.
        */
        Thread poll = new Thread(() -> {
            System.out.println("Poll started");
            System.out.println(arrayBlockingQueue.poll());
            System.out.println("Poll Finished, Null Response");
        });
        poll.start();


        /*
        Thread used to element in blocking queue.
        */
        Thread element = new Thread(() -> {
            System.out.println("Element started");
            try {
                System.out.println(arrayBlockingQueue.element());
            } catch (Exception exception) {
                System.out.println("Element Finished, " + exception.getClass() + " exception");
            }

        });
        element.start();


        /*
        Thread used to remove in blocking queue.
        */
        Thread remove = new Thread(() -> {
            System.out.println("Remove started");
            try {
                System.out.println(arrayBlockingQueue.remove());
            } catch (Exception exception) {
                System.out.println("Remove Finished, " + exception.getClass() + " exception");
            }

        });
        remove.start();



        /*
        Thread used to add element in blocking queue.
         */
        Thread adding = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Adding");
                arrayBlockingQueue.put(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        adding.start();


        peek.join();
        poll.join();
        element.join();
        remove.join();
        adding.join();

        System.out.println(arrayBlockingQueue);
    }
}
