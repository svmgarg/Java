package collections.copyOnWriteArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteTest {

    public static void main(String[] args) throws InterruptedException {

        final CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5));

        // new thread to concurrently modify the list
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // sleep a little so that for loop below can print part of
                    // the list
                    Thread.sleep(150, 555555);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                numbers.set(3, 66);
                System.out.println("Thread 1 : after changing an element : " + numbers);
            }
        }).start();

        // new thread to concurrently modify the list
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // sleep a little so that for loop below can print part of
                    // the list
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                numbers.add(90);
                System.out.println("Thread 2 : after adding an element : " + numbers);
            }
        }).start();


        /**
         * In foreach loop, iterating the list, changes made by Thread-1 and Thread-2 will not reflect.
         */
        for (int i : numbers) {
            System.out.println("By For Each ::::  " + i);
            // sleep a little to let other thread finish adding an element
            // before iteration is complete
            Thread.sleep(100);
        }
        System.out.println("Changes made by Thread-1 and Thread-2 was not reflecting during simultaneously iterating the list");

        System.out.println("\n\n************** Using List Iterator on CopyOnWriteArrayList ***************");

        ListIterator<Integer> listIterator = numbers.listIterator();
        while (listIterator.hasNext()) {
            int element = listIterator.next();
            switch (element) {
                case 1:
                    try {
                        listIterator.remove();
                    } catch (Exception ex) {
                        System.out.println("Can't Remove from List Iterator ::: " + ex.toString());
                    }
                    break;
                case 2:
                    try {
                        listIterator.set(10);
                    } catch (Exception ex) {
                        System.out.println("Can't Set from List Iterator ::: " + ex.toString());
                    }
                    break;
                case 3:
                    try {
                        listIterator.add(50);
                    } catch (Exception ex) {
                        System.out.print("Can't Add from List Iterator ::: " + ex.toString());
                    }
                    break;
            }
        }

        System.out.println("\n\n************** Using Iterator on CopyOnWriteArrayList ***************");

        Iterator<Integer> iterator = numbers.iterator();
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
        System.out.println("numbers : " + numbers);

    }
}

/**
 * 1. Multiple threads are allowed to operate on CopyOnWriteArrayList, as it works on separate cloned copy for update/modify operations
 *
 * 2. CopyOnWriteArrayList returns a fail safe iterator
 *          (While one thread iterating CopyOnWriteArrayList object, other threads happily can modify, as it works on separate cloned copy
 *           and it never throws ConcurrentModificationException)
 *
 * 3. CopyOnWriteArrayList class uses a mechanism called copy-on-write which makes a new copy of the elements  for every write operation (add, set, remove, etc)
 *          a) That means the read operations (get, iterator, listIterator,for-loop, etc) work on a different copy.
 *          b) In addition, a thread must acquire a separate lock before executing a write operation,
 *          and all write operations use this same lock so there’s only one write operation can be executed by only one thread at a time.
 *
 * 4. The methods iterator() and listIterator() return an iterator object that holds immutable snapshot copy of the elements.
 *          a) The method iterator() returns a generic Iterator that holds a snapshot of the list. This iterator doesn’t support the remove() method.
 *          b) The method listIerator() returns a generic ListIterator that holds a snapshot of the list. This iterator doesn’t support the remove(), set() or add()  method.
 *
 *
 *  5.In Add function of copy-on-write-arraylist
 *      first reentrant lock will be acquired
 *      then copy the array to new variable and
 *      then do modification and
 *      then set array and release lock
 *      Because of this behaviour, only one thread will be updating actual values, Hence making it consistent.
 *      and bacause of that we should use it when reading frequency is too high.
 *
 */


/**
 * why Iterators(remove) and List-Iterators(remove, add, set) are not allowed to modify the CopyOnWriteArrayList
 * Since the iterator()/listIterator() of a CopyOnWriteArrayList is only a snapshot of the list,
 * some element seen by the Iterator/List-Iterator could already been deleted/updated/added from the list by another thread,
 * thus it (again) might cause data inconsistency problem and JVM will be confused in merging the snapshot with original object.
 * The only logical consequence is to deny the operation by throwing an UnsupportedOperationException.
 */

/**
 * When to use ?
 *      we should use CopyOnWriteArrayList only when the number of write operations is very small
 *      as compared to the read operations and the list contains a small number of elements.
 */


/**
 *      Fail-Fast Iterator
 * If a thread modifies the structure of a collection i.e. add elements to it or remove elements from it,
 * while another thread (or same thread) is iterating over it, ConcurrentModificationException may be thrown by the iterator.
 * Iterator implementations that throws ConcurrentModificationException are known as fail fast iterators,
 * Collection classes other than in java.util.concurrent package return the Fail-fast iterators.
 * Example -  HashMap, ArrayList, Vector, Collections.synchronisedList , etc
 */


/**
 *     Fail-Safe Iterator
 *  Iterator implementations that don’t throw ConcurrentModificationException when a thread modifies the structure of a collection
 *  while another thread or same thread is iterating over it, are known as fail safe iterators as they work on new copy of the original collection.
 *  Collection classes in java.util.concurrent package return the Fail-safe iterators
 *  Example - CopyOnWriteArrayList, CopyOnWriteArraySet, ConcurrentHashMap, etc
 */

/**
 * References -
 *          https://netjs.blogspot.com/2016/01/copyonwritearraylist-in-java.html
 *          https://www.codejava.net/java-core/concurrency/java-concurrent-collection-copyonwritearraylist-examples
 *          http://www.benchresources.net/copyonwritearraylist-vs-synchronizedlist-in-java/
 *          https://stackoverflow.com/questions/28979488/difference-between-copyonwritearraylist-and-synchronizedlist
 */