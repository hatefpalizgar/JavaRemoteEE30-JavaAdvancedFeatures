package anonymous_class;

import abstraction.interfaces.Playable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        /* ========== Anonymous class using Abstract class ========== */


        // instantiating abstract classes is not possible but below is possible
        Animal kitty = new Cat("Kitty"); // kitty variable's class name is called Cat

        // below is an ad-hoc object creation
        // below we're instantiating an instance of Animal(abstract), with the specified name "dog"
        // and providing the implementation for makeSound()

        // NB! "dog" is the name of the instance variable NOT the name of the class
        // "dog" variable has no class name (anonymous)
        Animal dog = new Animal("Rex") {  // concrete class name: unknown OR anonymous
            @Override
            public void makeSound() {
                System.out.println("Woof Woof");
            }
        };

        dog.makeSound();

        // Anonymous class can be useful when you need to use a class just once, or when you need to override just
        // a few methods of a class or interface

        // Cons:
        // They can make code less readable, especially if the anonymous class is large or has lots of abstract methods


        // FYI, later we will take advantage of anonymous class concept massively in Lambda expressions


        /* ========== Anonymous class using interface ========== */
        // Similar to abstract class, we cannot instantiate interfaces.
        // Playable toy = new Playable(); // not possible
        Playable toy = new Playable() {
            @Override
            public void play() {
                //...
            }

            @Override
            public void love() {
                //...
            }
        };


        // ============================  Button Example from JavaFx =============================
        Button button = new Button("Click Me");

        // the argument passed to addActionListener() method below is an instance of anonymous class which will be
        // discarded as soon as it is used on line 63.
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        }

        );




    }
}
