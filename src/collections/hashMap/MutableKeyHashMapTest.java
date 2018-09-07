package collections.hashMap;

import java.util.HashMap;

/**
 * In the below example, we have created a HashMap Object "hashMap" and a MutableKey object "key"
 * Hashcode of "key" is 1291
 * Now, if we will insert the "key" into the "hasMap" then it will be mapped to 11th bucket
 * as default size of map is 16 and 1291 % 16 = 11
 *
 * now we are modifying the state of key
 * Here hashcode also got changed and i.e. 2241
 * so 2241 % 16 = 1
 * Now if we will do "hashMap.containsKey(key)" it will first calculate the hashcode of key i.e. 2241
 * and then check in bucket 1 where "key" will not be there .
 *
 * So , Mutable Key in HashMap is Dangerous..
 */
public class MutableKeyHashMapTest {

    public static void main(String[] args) {

        HashMap<MutableKey, String> hashMap = new HashMap();
        MutableKey key = new MutableKey(10, 20);
        //Hash code is 1291
        System.out.println("Hash code: " + key.hashCode());

        hashMap.put(key, "Dummy String");

        System.out.println("\nNow we are changing the state of key");

        key.setI(40);
        key.setJ(40);
        //Hash code is 1931
        System.out.println("\nHash code: " + key.hashCode());
        System.out.println("\n\nChecking the existence of key after state modification : hashMap.containsKey(key) :: " +  hashMap.containsKey(key));


    }
}

class MutableKey {
    private int i;
    private int j;

    public MutableKey(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public final int getI() {
        return i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    public final int getJ() {
        return j;
    }

    public final void setJ(int j) {
        this.j = j;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        result = prime * result + j;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MutableKey)) {
            return false;
        }
        MutableKey other = (MutableKey) obj;
        if (i != other.i) {
            return false;
        }
        if (j != other.j) {
            return false;
        }
        return true;
    }
}
