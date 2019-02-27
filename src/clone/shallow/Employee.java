package clone.shallow;


class Employee implements Cloneable {
    String name;
    Integer id;
    Address address;

    Employee(String name, int id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }


    /**
     * By default java will do shallow clone
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address=" + address +
                '}';
    }
}

