package designPattern.immutable;


class Employee implements Cloneable {

    String id;

    String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Overriding Clone method for dee
     * @return
     */
    @Override
    public Employee clone() {

        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone Not Supported");
        }

        return null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{ id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}