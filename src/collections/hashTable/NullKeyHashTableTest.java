package collections.hashTable;

import java.util.Hashtable;

public class NullKeyHashTableTest {
    public static void main(String args[]){

        Hashtable hashTable = new Hashtable();
        try{
            hashTable.put(null,new Object());
        }catch (Exception e){
            System.out.println("Exception raised is - java.lang.NullPointerException");
            System.out.println("Hence Null KEYS are not allowed in hash table");
        }



    }
}
