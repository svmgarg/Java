package designPattern.structural.facade;

import designPattern.structural.facade.shape.Circle;
import designPattern.structural.facade.shape.Rectangle;
import designPattern.structural.facade.shape.Shape;

public class ShapeMaker {

    private Shape circle;
    private Shape rectangle;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();

    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }


    public Shape getCircle() {
        return circle;
    }

    public void setCircle(Shape circle) {
        this.circle = circle;
    }

    public Shape getRectangle() {
        return rectangle;
    }

    public void setRectangle(Shape rectangle) {
        this.rectangle = rectangle;
    }
}
