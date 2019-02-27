package clone.shallow;

public class ShallowClone {
    public static void main(String[] args) {

        Address address = new Address("Ghaziabad", "Mandi");
        Employee shivam = new Employee("Shivam", 21140, address);
        Employee svm = null;
        try {
            //By default java will do shallow clone
            svm = (Employee) shivam.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        address.setCity("Hastinapur");
        /**
         * Here City name in svm object also got changed as by default
         * java will clone any object using shallow cloning technique
         */
        System.out.println(svm.address.getCity());

    }

}