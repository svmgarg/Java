package designPattern.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImmutablePatternTest {


    public static void main(String[] args) {

        HashMap mainMap = new HashMap<>();
        mainMap.put("1", "ONE");
        mainMap.put("2", "TWO");

        ArrayList mainList = new ArrayList();
        mainList.add("1");
        mainList.add("2");

        Employee employee = new Employee("svmgarg", "Shivam garg");
        ImmutableClass immutableClass = new ImmutableClass(mainMap, mainList, employee);

        System.out.println("HashMap Reference Same :: " + (immutableClass.getMap() == mainMap));
        System.out.println("List Reference Same :: " + (immutableClass.getList() == mainList));

        System.out.println("\n::::::::: After Modification ::::::::::");
        immutableClass.getList().add("3");
        immutableClass.getEmployee().setId("shivam.garg.188");
        System.out.println("Immutable object -> List  " + immutableClass.getList());
        System.out.println("Immutable object -> Employee  " + immutableClass.getEmployee());


    }
}



