package collections.linkedHashMap;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

    public static void main(String args[]){

        LinkedHashMap map  = new LinkedHashMap();

        map.put(3,3);
        map.put(2,2);
        map.put(1,1);
        map.put("String", "String");
        map.put("long", "String");
        map.put("3", "3");
        map.put(1,2);

        System.out.println(map);
    }
}
