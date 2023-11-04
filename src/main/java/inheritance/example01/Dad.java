package inheritance.example01;

// Class Dad inherits from class Person
// So, Dad is a Person as well
// Person is the superclass/parent class of Dad
// Dad is a subclass/child of Person
public class Dad extends Person {

    // To build any instance of a subclass/child you should know first how to build an instance of a superclass/parent
    public Dad(String name, int age, String hairColor) {
        // `super` keyword is used to call the constructor of the superclass
        super(name, age, hairColor);  // You have to first construct(birth) the parent class
    }

    public void work() {
        System.out.println("Dad works harder");
    }

    // Override method play() from class Person
    // This means play() in Person is overridden
    // This process is called method overriding (overwrite)
    // So, any instance of Dad class can have its own way of playing

    @Override
    public void play() {
        System.out.println("Dad plays with his kids");
    }

    // Putting @Override annotation is optional,
    // BUT, it is recommended and is a good practice.
    @Override
    public void eat() {
        System.out.println("Dad eats steak");
    }


}
