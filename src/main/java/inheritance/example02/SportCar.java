package inheritance.example02;

// Any class in Java is allowed to extend(inherit) ONLY ONE class (not more)
// "MULTIPLE INHERITANCE" is forbidden in Java
// So SportCar can NOT extend both Car and UltraSportCar, only one of them is possible
// Object is the only exception to this rule. Every Class in Java extends Object implicitly
public class SportCar extends Car{
    public SportCar(String model) {
        super(model);
    }

    public void boostSpeed() {
        System.out.println("invoked boostSpeed() --> SportCar");
    }

    @Override
    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() --> SportCar");
    }
}
