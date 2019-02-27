package clone.deep;

public class DeepClone {

    public static void main(String args[]) {

        Address address = new Address("Haryana", "India");
        Employee shivam = new Employee(10L, "Shivam", address);

        Employee svm =null;
        try {
            svm =shivam.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        address.setState("UP");
        /**
         * Here City name in svm object also got changed as by default
         * java will clone any object using shallow cloning technique
         */
        System.out.println(svm.getAddress().getState());
    }
}
