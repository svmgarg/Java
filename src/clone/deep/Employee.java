package clone.deep;

public class Employee implements Cloneable {

    private Long id;
    private String name;
    private Address address;

    public Employee(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        Employee employee = (Employee) super.clone();
        employee.setAddress(this.address.clone());
        return employee ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}