package clone;

public class ShallowClone {
    public static void main(String[] args) {

        ShallowClone object = new ShallowClone();
        Address address = object.new Address("Ghaziabad", "Mandi");
        Employee shivam = object.new Employee("Shivam", 21140, address);
        Employee svm = null;
        try {
            svm = (Employee) shivam.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        address.city = "Hastinapur";
        /**
         * Here City name in svm object also got changed as by default
         * java will clone any object using shallow cloning technique
         */
        System.out.println(svm.address.city);

    }

    class Employee implements Cloneable {
        String name;
        Integer id;
        Address address;

        Employee(String name, int id, Address address) {
            this.name = name;
            this.id = id;
            this.address = address;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    class Address {
        String city;
        String street;

        Address(String city, String street) {
            this.city = city;
            this.street = street;
        }
    }

}