package collections.listIterators;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorAddTest {

    public static void main(String args[] ){

        ArrayList<Integer> aList = new ArrayList<>();

        aList.add(1);
        aList.add(3);
        aList.add(5);
        aList.add(4);
        aList.add(7);
        aList.add(9);

        ArrayList<Integer> aList1 = new ArrayList<>();
        for(int i  =0; i<aList.size();i++){
            aList1.add(aList.get(i));
            if((i+1) < aList.size() &&  aList.get(i+1)%2==0){
                i++;
                aList1.add(aList.get(i));
            }else{
                aList1.add(2);
            }

        }
        System.out.print(aList1);
        /*ListIterator<Integer> iterator = aList.listIterator();

        while(iterator.hasNext()){
            Integer i  = iterator.next();
            int nextIndex = 0;
            if(iterator.hasNext()){
                nextIndex =  iterator.nextIndex();
            }
            if(i%2 ==0 && aList.get(nextIndex) %2 !=0){
                iterator.add(2);

            }
        }

        System.out.print(aList);
*/

    }
}
