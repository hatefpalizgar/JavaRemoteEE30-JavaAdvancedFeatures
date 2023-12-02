package functional_programming.method_references;

/**
 * <h1>Method reference to a constructor OR <code>constructor references</code></h1>
 */
public class Example04 {
    public static void main(String[] args) {
        // approach 1. using lambda expression
        // ManufactureFI factory = number ->  new Battery(number);


        // approach 2. using Method references
        // This is possible only because the Battery constructor is similar to manufacture() method
        ManufactureFI factory = Battery::new;

        factory.manufacture(100);
    }
}


@FunctionalInterface
interface ManufactureFI {
    Battery manufacture(int value);
}


class Battery {
    public Battery(int capacity) {
        System.out.println("Battery is created with capacity: " + capacity);
    }
}