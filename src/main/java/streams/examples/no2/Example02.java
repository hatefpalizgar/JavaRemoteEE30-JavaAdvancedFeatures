package streams.examples.no2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example02 {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        // To create a stream:
        //  1. call stream() method on the collection
        Stream<String> stream = someBingoNumbers.stream();


        //  2. create a stream without having any collection first
        Stream<String> outNumberStream = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I29", "071");

        Stream<String> concatStream = Stream.concat(outNumberStream, inNumberStream);

        concatStream.distinct().forEach(e -> System.out.println(e));  // distinct() removes duplicates

        // What is the output?
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        // Avoid using peek() in production environment. It's useful for debugging purpose.

        // Operations in Streams API is classified as
        // 1. Intermediate Operations: filter(), map(), distinct(), ...
        // 2. Terminal Operations: count(), collect(), forEach(), ...
    }
}
