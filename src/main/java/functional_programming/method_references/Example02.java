package functional_programming.method_references;

/**
 * <h1>Method reference to a static method of a class</h1>
 */
public class Example02 {
    public static void main(String[] args) {
        // Calculator calculator = (numA, numB) -> numA * numB;  // impl1. using lambda expression

        Calculator calculator = Multiplication::multiply; // impl2.using method references

        int result = calculator.calculate(11, 5); // 11 * 5 = 55
        System.out.println("product of given numbers is: " + result);
    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}


class Multiplication {
    public static int multiply(int a, int b) {
        return a * b;
    }
}