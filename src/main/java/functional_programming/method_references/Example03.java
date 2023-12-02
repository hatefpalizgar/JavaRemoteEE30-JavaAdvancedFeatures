package functional_programming.method_references;

import java.util.Arrays;

/**
 * <h1>
 * Method reference to an instance method of an arbitrary object of a particular type
 * </h1>
 **/
public class Example03 {
    public static void main(String[] args) {
        String[] stringArray = {"Steve", "Rick", "Mary", "Lucy", "Sam", "John"};

        Arrays.sort(
                stringArray,
                String::compareToIgnoreCase
        );

        for (String name : stringArray) {
            System.out.println(name);
        }

    }
}
