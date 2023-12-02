package streams;

import java.util.Arrays;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Sarah", "Mark", "Tyla", "Ellisha", "Eamonn");

        // Use Streams API to complete:

        // a. sort the list and print them out
        names.stream()
                .sorted()
                .forEach(System.out::println);

        // b. print only those names that start with 'E' letter and print them out
        names.stream()
                .filter(name -> name.startsWith("E"))
                .forEach(System.out::println);

        // c. print all names in uppercase format and print them out
        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);


    }
}
