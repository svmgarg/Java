package collections.blockingQueue.arrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * The peek() method retrieves the value of the first element of the queue without removing it from the queue. For each invocation of the method
 * we always get the same value and its execution does not affect the size of the queue. If the queue is empty the peek() method returns null.
 * <p>
 * <p>
 * The element() method behaves like peek(), so it again retrieves the value of the first element without removing it. Unlike peek, if the list is empty element()
 * throws a NoSuchElementException
 * <p>
 * <p>
 * The poll() method retrieves the value of the first element of the queue by removing it from the queue. At each invocation it removes the first element
 * of the list and if the list is already empty it returns null but does not throw any exception
 * <p>
 * <p>
 * The remove() method behaves as the poll() method, so it removes the first element of the list and if the list is empty it throws a NoSuchElementException
 * <p>
 * The take() method is thread safe method, if queue is empty then
 */
public class ArrayBlockingQueueTakeTest {

    public static void main(String args[]) throws InterruptedException {

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(10);

        /*
        Thread used to peek in blocking queue.
        */
        Thread take = new Thread(() -> {
            System.out.println("Take started");
            try {
                System.out.println(arrayBlockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Take Finished, Null response");
        });
        take.start();

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


        take.join();
        adding.join();

        System.out.println(arrayBlockingQueue);
    }
}
