package designPattern.creational.immutable;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Basic idea behind Immutable Design pattern is -
 *
 * 1. make class final, so that it can not be extended
 * 2.make all methods private which can change the state of a object
 * 3.Expose one public constructor to allow outside world to create objects.
 * 4.In constructor do deep clone whie copying values from outside world to object
 * 5.while returning values to outside world, returning with deep cloning, to preserve internal state of a object.
 * 6. make all the fields final so their reference can't be changed.
 *
 */
final class ImmutableClass {

    final private HashMap map;
    final private ArrayList list;
    final private Employee employee;

    public ImmutableClass(HashMap property, ArrayList list, Employee employee) {
        this.map = new HashMap(property);
        this.list = new ArrayList(list);
        this.employee =  employee.clone();
    }

    public HashMap getMap() {
        return map;
    }

    public ArrayList getList() {
        return (ArrayList) list.clone();
    }

    public Employee getEmployee() {
        return employee.clone();
    }
}
