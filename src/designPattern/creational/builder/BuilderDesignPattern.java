package designPattern.creational.builder;

/**
 * Complex constructor.
 * Multiple constructor having combinations of multiple parameter with nested objects
 *
 * Immutability.
 * You can force the immutability to the object once you are done with creation of object.
 *
 */
public class BuilderDesignPattern {

    public static  void main(String[] args){

        Employee employee = new Employee.EmployeeBuilder().name("Shivam").department("Computer").designation("Engineer").build();
    }

}

