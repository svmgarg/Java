package collections.copyOnWriteArraySet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteTest {

    public static void main(String[] args) throws InterruptedException {

        final CopyOnWriteArraySet<Integer> numberSet= new CopyOnWriteArraySet<>(
                Arrays.asList(1, 2, 3, 4, 5));

        // new thread to concurrently modify the list
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // sleep a little so that for loop below can print part of set
                    Thread.sleep(150, 555555);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                numberSet.add(6);
                System.out.println("Thread 1 : after changing an element : " + numberSet);
            }
        }).start();

        // new thread to concurrently modify the set
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // sleep a little so that for loop below can print part of set
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                numberSet.add(7);
                System.out.println("Thread 2 : after adding an element : " + numberSet);
            }
        }).start();


        /**
         * In foreach loop, iterating the list, changes made by Thread-1 and Thread-2 will not reflect.
         */
        for (int i : numberSet) {
            System.out.println("By For Each ::::  " + i);
            // sleep a little to let other thread finish adding an element
            // before iteration is complete
            Thread.sleep(100);
        }
        System.out.println("Changes made by Thread-1 and Thread-2 was not reflecting during simultaneously iterating the copyOnWriteArraySet");

        System.out.println("\n\n************** Using Iterator on CopyOnWriteArraySet ***************");

        Iterator<Integer> iterator = numberSet.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            switch (element) {
                case 1:
                    try {
                        iterator.remove();
                    } catch (Exception ex) {
                        System.out.println("Can't Remove from Iterator ::: " + ex.toString());
                    }
                    break;
            }
        }
        System.out.println("numbers : " + numberSet);

    }
}

/**
 * 1. Multiple threads are allowed to operate on CopyOnWriteArraySet, as it works on separate cloned copy for update/modify operations
 *
 * 2. CopyOnWriteArraySet returns a fail safe iterator
 *          (While one thread iterating CopyOnWriteArraySet object, other threads happily can modify, as it works on separate cloned copy
 *           and it never throws ConcurrentModificationException)
 *
 * 3. CopyOnWriteArraySet class uses a mechanism called copy-on-write which makes a new copy of the elements  for every write operation (add, remove, etc)
 *          a) That means the read operations (get, iterator, for-loop etc) work on a different copy.
 *          b) In addition, a thread must acquire a separate lock before executing a write operation,
 *          and all write operations use this same lock so there’s only one write operation can be executed by only one thread at a time.
 *
 * 4. The methods iterator() return an iterator object that holds immutable snapshot copy of the elements.
 *          a) The method iterator() returns a generic Iterator that holds a snapshot of the list. This iterator doesn’t support the remove() method.
 */


/**
 * why Iterators(remove) are not allowed to modify the CopyOnWriteArraySet
 * Since the iterator() of a CopyOnWriteArraySet is only a snapshot of the set,
 * some element seen by the Iterator could already been deleted/updated/added from the set by another thread,
 * thus it (again) might cause data inconsistency problem and JVM will be confused in merging the snapshot with original object.
 * The only logical consequence is to deny the operation by throwing an UnsupportedOperationException.
 */


/**
 * CopyOnWriteArraySet  is backed-up by CopyOnWriteArrayList to achieve the concurrent functionality.
 * Note - we should use CopyOnWriteArraySet only when the read operations outnumber the write operations
 *        and has a small number of elements, because the set creates a new copy of its elements for each write operation,
 *        which affects performance if the set has a large number of elements and the write operations are frequent.
 */



/**
 *      Fail-Fast Iterator
 * If a thread modifies the structure of a collection i.e. add elements to it or remove elements from it,
 * while another thread (or same thread) is iterating over it, ConcurrentModificationException may be thrown by the iterator.
 * Iterator implementations that throws ConcurrentModificationException are known as fail fast iterators,
 */


/**
 *     Fail-Safe Iterator
 *  Iterator implementations that don’t throw ConcurrentModificationException when a thread modifies the structure of a collection
 *  while another thread or same thread is iterating over it, are known as fail safe iterators as they work on new copy of the original collection.
 */



/**
 * References -
 *          https://netjs.blogspot.com/2016/03/copyonwritearrayset-in-java-concurrency.html
 *          https://www.codejava.net/java-core/concurrency/java-concurrent-collection-copyonwritearraylist-examples
 *          http://www.benchresources.net/copyonwritearrayset-vs-synchronizedset-in-java/
 *          https://stackoverflow.com/questions/28979488/difference-between-copyonwritearraylist-and-synchronizedlist
 */