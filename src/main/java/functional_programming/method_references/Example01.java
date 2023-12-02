package functional_programming.method_references;

/**
 * Method reference is a shorthand notation of a lambda expression to call a method.
 * If your lambda expression is like this:
 * <pre>
 *     str -> System.out.println(str)
 *  </pre>
 * then you can replace it with a method reference like this:
 * <pre>
 *      System.out::println
 *  </pre>
 * The <code>::</code> operator is used in method reference to separate the class or object from the method name
 * <br><br>
 * <h2>Four types of method references:</h2>
 * <li>Method reference to an instance method of an object – <code> object::instanceMethod </code></li>
 * <li>Method reference to a static method of a class – <code> Class::staticMethod </code></li>
 * <li>Method reference to an instance method of an arbitrary object of a particular type – <code> Class::instanceMethod </code></li>
 * <li>Method reference to a constructor – <code> Class::new </code></li>
 *
 * @see <a href="https://beginnersbook.com/2017/10/method-references-in-java-8/">method-references-in-java-8</a>
 * <pre></pre>
 * <h1>Method reference to an instance method of an object:</h1>
 * */


public class Example01 {
    public static void main(String[] args) {
        Displayable displayable1 = () -> System.out.println("Hello World");
        displayable1.display(); // prints "Hello World"

        Printer printer = new Printer();

        // anything I put on the right side of this equation that follows the structure
        // of display() method, is correct and works.
        // printer::print is literally referencing print() of printer object
        Displayable displayable2 = printer::print;
        displayable2.display();  // prints "instance method"

        // above code on line 13 is equivalent to below code
        // Displayable displayable2 = () -> printer.print();

        // Using printer::print you are telling displayable2 object to use the same
        // logic inside print() of the printer object and don't expect us to write the lambda
        // expression explicitly

        // NB!
        // on either of lines 5 or 13 above, we are not calling any method; we are just
        // REFERENCING it.

    }
}


@FunctionalInterface
interface Displayable {
    void display();
}


class Printer {
  public void print() {
      System.out.println("instance method");
  }
}