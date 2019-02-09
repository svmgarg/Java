package collections.hashTable;

import java.util.Hashtable;

public class NullValueHashTableTest {
    public static void main(String args[]){

        Hashtable hashTable = new Hashtable();
        try{
            hashTable.put(new Object(), null);
        }catch (Exception e){
            System.out.println("Exception raised is - java.lang.NullPointerException");
            System.out.println("Hence Null VALUES also  are not allowed in hash table");
        }



    }
}
