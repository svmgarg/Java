package designPattern.builder;

public class BuilderDesignPattern {

    public static  void main(String[] args){

        Employee employee = new Employee.EmployeeBuilder().name("Shivam").department("Computer").designation("Engineer").build();
    }

}

