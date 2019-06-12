package generics;

public class Test1 {
    public static void main(String[] args) {
        Tea t = new Tea();
        Water w = new Water();
        Glass<Tea> teaGlass = new Glass<>();
        teaGlass.liquid = t;
        Glass<Water> waterGlass = new Glass<>();
        waterGlass.liquid = w;
    }
}

class Glass<T> {
    T liquid;
}

class Tea {

}

class Water {

}