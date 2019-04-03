package collections.listIterators;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListIteratorAddTest {

    static CopyOnWriteArrayList<Integer> aList;

    public static void main(String args[]) {

        initData();
        iterator();

        initData();
        //forloop();
    }


    static void iterator() {
        ListIterator<Integer> iterator = aList.listIterator();

        int counter = 0;
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (counter == 2) {
                aList.add(2);
            }
            counter++;
            System.out.println(i);
        }
        System.out.println(aList);
    }

    static void forloop() {

        int counter = 0;
        for(int i : aList){
            if (counter == 2) {
                aList.add(2);
            }
            counter++;
            System.out.println(i);
        }
        System.out.println(aList);
    }



    static void initData() {
        aList = new CopyOnWriteArrayList();
        aList.add(1);
        aList.add(3);
        aList.add(5);
        aList.add(4);
        aList.add(7);
        aList.add(9);
    }


}