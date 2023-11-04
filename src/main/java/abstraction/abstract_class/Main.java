package abstraction.abstract_class;

public class Main {
    public static void main(String[] args) {
        // We can not instantiate an abstract class
        // MyAbstractClass aClass = new MyAbstractClass();
        MyConcreteClass aClass = new MyConcreteClass();
        aClass.concreteMethod();
        aClass.abstractMethod();

        System.out.println("========== POLYMORPHISM ===========");
        MyAbstractClass bClass = new MyConcreteClass();
        bClass.concreteMethod();
        bClass.abstractMethod();



    }
}
