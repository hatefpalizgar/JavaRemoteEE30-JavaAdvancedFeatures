package generics;
/*
 * ==============================================================================================
 *                                      Generics
 * ==============================================================================================
 *
 * Generics are a way to create reusable code that can be used with different types.
 * A generic type is a generic class or interface that is parameterized over types.
 *
 * There is a convention that the parameterized type name is a single UPPERCASE letter.
 * Also, there is a convention specifying which letter should be used:
 *  E, T - element type
 *  K - key type
 *  V - value type
 *  T - type
 *  N - number type
 *  S, U, V if there are more parameterized types
 */
public class Main {
    public static void main(String[] args) {
        Car toyota = new Car();

        CarBox boxWithACarInIt = new CarBox(toyota);  // CarBox can store only Car objects

        // What if we wanted to have a Box that could store every type of object?
        // Answer: Let's introduce generics (T)
        GenericBox<Car> boxWithACar = new GenericBox<>(toyota);
        GenericBox<String> boxWithString = new GenericBox<>("Hello");

        // I want to design a Garage class that can hold only instances of Vehicle
        Garage<Car> garage = new Garage<>(toyota);
        Garage<Vehicle> garage2 = new Garage<>(toyota);
        // Garage<String> stringGarage = new Garage<>("Hello");  // Not possible since String not extends Vehicle

        garage.repairVehicle();  // "Car is repaired"

        LuxuryCar porsche = new LuxuryCar();

        // Now I want my GenericBox instance to be flexible to take not just Car BUT
        // also any subclass of Car
        // Below we can pass to the constructor any Car or subclasses of Car like LuxuryCar
        GenericBox<? extends Car> box1 = new GenericBox<>(toyota);
        GenericBox<? extends Car> box2 = new GenericBox<>(porsche);

        // Now I want my GenericBox instance to be flexible to take not just LuxuryCar BUT
        // also any superclass of LuxuryCar
        // Below we can pass to the constructor any LuxuryCar or superclasses of LuxuryCar like Car
        GenericBox<? super LuxuryCar> box3 = new GenericBox<>(porsche);
        GenericBox<? super LuxuryCar> box4 = new GenericBox<>(toyota);

        // Below we can pass to the constructor any LuxuryCar or superclasses of LuxuryCar
        Garage<? super LuxuryCar> superGarage = new Garage<>(porsche);
        Garage<? super LuxuryCar> superGarage2 = new Garage<>(toyota);
        // Below we can pass to the constructor any LuxuryCar or subclasses of LuxuryCar
        Garage<? extends LuxuryCar> superGarage3 = new Garage<>(porsche);


    }
}
