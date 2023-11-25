package functional_programming.functional_interfaces;


/*
 * Functional Interface is an interface with EXACTLY one ABSTRACT method
 * @FunctionalInterface is added so that we can mark an interface as functional.
 * Putting this annotation is optional but suggested to prevent accidental extra methods.
 *
 * a functional interface can contain any number of default or static methods.
 * A functional interface can only extend another interface ONLY when the parent interface does not have any abstract method
 *
 * We have JDK built-in func interfaces like Runnable, Callable, Comparator, ActionListener etc.
 * */

@FunctionalInterface
public interface Printable {
    void print(String message);

    default void someMethod() {
        // default methods are allowed in functional interfaces
    }

    static void save2() {
        // static methods are allowed in functional interfaces
    }
}
