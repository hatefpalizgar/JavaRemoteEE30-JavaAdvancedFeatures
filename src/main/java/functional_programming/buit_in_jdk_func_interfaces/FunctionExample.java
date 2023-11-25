package functional_programming.buit_in_jdk_func_interfaces;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> func = input -> input.substring(5);

        String output = func.apply("This is a test Function interface in Java 8+");

        System.out.println(output);

        // Functions can have different types of input and output
        Function<String, Integer> characterCounter = txt -> txt.length();

        System.out.println(characterCounter.apply("Hello World"));

        /**
         * Next:
         * @see PredicateExample
         * */
    }
}
