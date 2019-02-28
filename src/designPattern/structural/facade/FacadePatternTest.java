package designPattern.structural.facade;

public class FacadePatternTest {

    public static void main(String args[]){

        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.getCircle().draw();
        shapeMaker.getRectangle().draw();
    }
}
