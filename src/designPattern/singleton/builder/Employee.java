package designPattern.singleton.builder;

public class Employee {

    private String name;
    private String designation;
    private String department;

    Employee(EmployeeBuilder builder){
        this.name = builder.name;
        this.department  = builder.department;
        this.designation = builder.designation;
    }


    public static class EmployeeBuilder{
        private String name;
        private String designation;
        private String department;

        public EmployeeBuilder name(String name){
            this.name=name;
            return this;
        }

        public EmployeeBuilder designation(String designation){
            this.designation=designation;
            return this;
        }

        public EmployeeBuilder department(String department){
            this.department=department;
            return this;
        }

        public Employee build(){
            return  new Employee(this);
        }



    }

}