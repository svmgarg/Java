package designPattern.immutable;

import java.util.ArrayList;
import java.util.HashMap;

final class ImmutableClass {

    final private HashMap map;

    final private ArrayList list;

    final private Employee employee;

    public ImmutableClass(HashMap property, ArrayList list, Employee employee) {
        this.map = new HashMap(property);
        this.list = new ArrayList(list);
        this.employee = (Employee) employee.clone();
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
