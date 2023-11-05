package anonymous_class;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // abstract method cause we care only about WHAT every Animal should do
    // the exact implementation (HOW) falls on the specific subclass of Animal (like Cat)
    public abstract void makeSound();

    public void eat() {
        System.out.println("Animal is eating");
    }

}
