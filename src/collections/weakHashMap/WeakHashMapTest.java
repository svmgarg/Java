package collections.weakHashMap;

import java.util.WeakHashMap;

public class WeakHashMapTest {

    public static void main(String args[]) throws InterruptedException {


        WeakHashMap<Object, String> weakMap = new WeakHashMap<Object, String>();
        for(int i = 0;i<10;i++){
            Object obj = new Object();
            weakMap.put(obj, "value");
        }

        System.out.println("Current size of Weak Map is : " + weakMap.size());
        System.out.println("Current State of Weak Map is :\n"+weakMap);

        //obj2 = null;
        System.gc();
        Thread.sleep(2000);
        System.out.println(weakMap.size());
    }
}
/**
 * In tha above Example, we have  a Weak HashMap in which we are adding the objects in a loop
 * After addition of elements, we are printing the size of weak hashMap which is 10
 *
 * After that we have called System.gc and we can see that after this size of weak HashMap is 0
 */
/**
 * Explaination ::
 *      WeakHashmap uses WeakReferece as it’s keys. So these keys will get collected whenever GC is invoked.
 *      Key is stored as a WeakReference which has a ReferenceQueue(queue). Whenever JVM collects the WeakReference key,
 *      it adds this reference to the queue. So WeakHashmap class always checks this queue and if it finds any reference,
 *      it deletes it from its own table also.
 */


/**
 *
 * 1) Strong References
 *      These type of references we use daily while writing the code.
 *      Any object in the memory which has active strong reference is not eligible for garbage collection.
 * 2) Soft References
 *      The objects which are softly referenced will not be garbage collected (even though they are available for garbage
 *      collection) until JVM badly needs memory. These objects will be cleared from the memory only if JVM runs out of memory.
 * 3) Weak Reference
 *      A weakly referenced object is cleared by the Garbage Collector when it’s weakly reachable.
 *      Weak reachability means that an object has neither strong nor soft references pointing to it.
 *      The object can be reached only by traversing a weak reference.
 *  4) Phantom Reference
 */