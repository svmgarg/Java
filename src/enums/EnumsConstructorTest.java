package enums;

public class EnumsConstructorTest {

    static{
        System.out.print("sdf");
    }

    public static void main(String args[]) {


    }

}


enum Day {

    SUNDAY(), MONDAY, TUESDAY(2), WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    int value;
    private Day(int value) {
        System.out.println("arg cons");
        this.value = value;
    }

    private Day() {
        System.out.println("no arg cons");
    }

}