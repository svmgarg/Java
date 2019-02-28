package designPattern.structural.facade.shape;

public class Circle implements  Shape{

    @Override
    public void draw() {
        System.out.println("Circle drawn");
    }
}
