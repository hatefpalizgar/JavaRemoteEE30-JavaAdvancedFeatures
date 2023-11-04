package inheritance.example02;

// Every class in Java inherits by default (implicitly) another superclass called 'Object'
public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() --> Car");
    }

    public String getModel() {
        return model;
    }



    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }


}
