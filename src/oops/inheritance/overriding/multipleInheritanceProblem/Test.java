package oops.inheritance.overriding.multipleInheritanceProblem;

public class Test implements A, B {


    @Override
    public Integer function() {
        return null;
    }

}


interface A {

    Number function();
}

interface B {
    Integer function();
}