package designPattern.creational.prototype;

/**
 * What's the point of the Prototype design pattern?
 *
 * The Prototype pattern is a creation pattern based on cloning a pre-configured object.
 * The idea is that you pick an object that is configured for either the default or in the ballpark of
 * some specific use case and then you clone this object and configure to your exact needs.
 *
 * The pattern is useful to remove a bunch of boilerplate code, when the configuration required
 * would be onerous. I think of Prototypes as a preset object, where you save a bunch of state as a new starting point.
 */
public class ProtoTypePatternTest {

    public static void main(String args[]) throws CloneNotSupportedException {

        Employee shivam = new Employee(10L, "Shivam");
        Employee svm = shivam.clone();
        svm.setName("svm");
        Employee atSvm = svm.clone();
        svm.setName("atsvm");
        System.out.println(shivam);
        System.out.println(svm);
        System.out.println(atSvm);
    }
}
