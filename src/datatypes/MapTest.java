package datatypes;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static  void main(String args[]){
        MapTest object = new MapTest();
        HashMap<Key, Object> m = new HashMap<>();
        MapTest.Key key = object.new Key(10,5);
        m.put(key, new Object());
        /**
         * Upto This we have created a object and  inserted a pair(key , object)
         * and after that we will modify the key object and same will reflect in map also.
         */
        key.a=15;
        for(Map.Entry<Key, Object> entry : m.entrySet()){
            System.out.println(entry.getKey().a);
        }
    }

    class Key
    {
        int a;
        int b;
        Key(int a, int b){
            this.a=a;
            this.b =b;
        }
        public void setA(int a) {
            this.a = a;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
