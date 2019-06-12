package serialization.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BasicDeserializationTest {
    public static void main(String args[]) {


        try {
            FileInputStream fis = new FileInputStream("employee.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
            Employee deserEmployee = (Employee) objectInputStream.readObject();

            System.out.println(deserEmployee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis1 = new FileInputStream("employee1.txt");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fis1);
            Employee deserEmployee1 = (Employee) objectInputStream1.readObject();

            System.out.println(deserEmployee1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
