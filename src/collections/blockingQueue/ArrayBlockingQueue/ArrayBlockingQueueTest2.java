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
public class ArrayBlockingQueueTest2 {

    public static void main(String args[]) throws InterruptedException {

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(10);
        arrayBlockingQueue.put(10);
        arrayBlockingQueue.put(20);
        arrayBlockingQueue.put(30);
        arrayBlockingQueue.put(40);
        arrayBlockingQueue.put(50);
        arrayBlockingQueue.put(60);


        System.out.println("Peek started");
        System.out.println(arrayBlockingQueue.peek());
        System.out.println("Peek Finished, queue : " + arrayBlockingQueue);

        System.out.println("\nPoll started");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println("Poll Finished, queue : " + arrayBlockingQueue);


        System.out.println("\nElement started");
        System.out.println(arrayBlockingQueue.element());
        System.out.println("Element Finished, queue : " + arrayBlockingQueue);

        System.out.println("\nRemove started");
        System.out.println(arrayBlockingQueue.remove());
        System.out.println("Remove Finished, queue : " + arrayBlockingQueue);

        System.out.println(arrayBlockingQueue);
    }
}
