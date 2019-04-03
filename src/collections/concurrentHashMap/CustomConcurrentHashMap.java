package collections.concurrentHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
//http://javaexplorer03.blogspot.com/2015/11/why-concurrenthashmap-does-not-allow.html
public class CustomConcurrentHashMap {
    public static void main(String args[]) {

        ConcurrentHashMap o =null;

        CustomConcurrentHashMap object = new CustomConcurrentHashMap();
        MyConcurrentHashMap myConcurrentHashMap = new MyConcurrentHashMap(16, .75f, 16);
        System.out.println(myConcurrentHashMap.hashCode());
    }
}

class MyConcurrentHashMap<K, V> {

    private int initialCapacity;

    private int concurrencyLevels;

    private float loadFactor;

    Entry<K, V> shards[];

    MyConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevels) {
        shards = new Entry[initialCapacity];
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.concurrencyLevels = concurrencyLevels;

    }

    static class Entry<K, V> {
        int hashcode;
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V put(K key, V value) {

        int hashCode = key.hashCode();
        int bucketNumber = hashCode % initialCapacity;
        Entry<K, V> buckedEntry = shards[bucketNumber];
        Entry<K,V>  newEntry = new Entry<>(key, value, null);
        newEntry.hashcode = hashCode;
        synchronized (buckedEntry) {
            if (buckedEntry == null) {
                shards[bucketNumber] = newEntry;

            } else {
                Entry<K, V> temp = buckedEntry;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newEntry;
            }

        }
        return null;
    }

    public void rehash(){
        int newInitialCapacity = initialCapacity*2;
        Entry<K, V> shards[] = new Entry[newInitialCapacity ];
        for(Entry<K,V>  entry : shards){
            if(entry!= null){
                Entry<K,V> currentEntry = entry;
                while(entry != null){
                    int newBucketNumber  = entry.hashcode % newInitialCapacity;
                }
            }
        }


    }

}

