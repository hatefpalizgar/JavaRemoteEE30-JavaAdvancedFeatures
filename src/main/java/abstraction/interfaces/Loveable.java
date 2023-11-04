package abstraction.interfaces;
// Interface:
// 1. Any abstract method is public and abstract by default
// 2. Prior to Java 8, only abstract methods were allowed in interfaces.
// 3. But from Java8+, it is also possible to have concrete methods in interfaces BUT, you have to define them as 'default'
// 4. You can also have concrete methods that are static

// interface is a contract
public interface Loveable {

    void love();

    // concrete
    default void concreteMethod() {

    }

    static int getAge() {
        return 0;
    }

}
