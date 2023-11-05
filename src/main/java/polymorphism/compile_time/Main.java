package polymorphism.compile_time;

// Polymorphism:
// Polymorphism(multiple+form) is the ability of an object to take on many forms.
// The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.
// In other words, the child class can be used as the parent class.
// This is much like a child can be used as a parent in the real world:
// Let's say you as the child try to show up at the parents' party and all you have to do is to mimic your dad's behaviour

// In Java polymorphism is achieved in two ways:
// 1. Method overloading (compile-time polymorphism)
//      Method overloading happens when various methods with the SAME name
//      but DIFFERENT number, order or types of parameters are present in a class.
//      Learn more: https://www.softwaretestinghelp.com/polymorphism-in-java/#:~:text=overloading%20in%20general.-,Method%20Overloading%20In%20Java,have%20%E2%80%9Coverloaded%E2%80%9D%20the%20methods
// 2. Method overriding (runtime polymorphism)
//      Method overriding occurs when a child class overrides a method of its parent
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // depending on the input arguments type, add() exposes a different behaviour
        calculator.add(3,4); // calls 1st method
        calculator.add("Hello", " World"); // calls 2nd method
    }
}


class Calculator {

    public void add(int a, int b) {
        System.out.println("Addition of two numbers is: " + (a + b));
    }

    public void add(String a, String b) {
        System.out.println("Addition of two strings is: " + a + b);
    }
}
