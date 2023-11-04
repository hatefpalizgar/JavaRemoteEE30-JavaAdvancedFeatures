package abstraction.abstract_class;

// Abstract class in Java:
// 1. should be declared using 'abstract' keyword
// 2. can have fields
// 3. can have 0 or more concrete methods
// 4. can have 0 or more abstract methods

public abstract class MyAbstractClass {

    public abstract void abstractMethod();

    public void concreteMethod() {
        System.out.println("inside concreteMethod() --> MyAbstractClass");
    }

}
