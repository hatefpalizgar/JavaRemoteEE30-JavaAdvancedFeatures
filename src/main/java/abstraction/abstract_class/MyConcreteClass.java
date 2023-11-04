package abstraction.abstract_class;

// When extending(subclass) an abstract class,
// Java forces us to implement ALL the abstract methods
public class MyConcreteClass extends MyAbstractClass {

    @Override
    public void abstractMethod() {
        System.out.println("inside abstractMethod() --> MyConcreteClass");
    }

}

