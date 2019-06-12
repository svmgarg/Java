package serialization.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BasicTest {
    public static void main(String args[]) {
        BasicTest object = new BasicTest();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("employee.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            Employee employee = new Employee();
            employee.setId(10);
/*
            employee.setName("Shivam");
*/
            employee.setType("REGULAR");

            objectOutputStream.writeObject(employee);


            FileOutputStream fileOutputStream1 = new FileOutputStream("employee1.txt");
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);

            Employee employee1 = new Employee();
            employee1.setId(204);
//            employee1.setName("AAAAA");
            employee1.setType("LLLLLLL");

            objectOutputStream1.writeObject(employee1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

