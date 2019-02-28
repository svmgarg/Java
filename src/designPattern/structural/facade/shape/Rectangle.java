package designPattern.structural.facade.shape;

public class Rectangle  implements   Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle drawn");
    }
}
