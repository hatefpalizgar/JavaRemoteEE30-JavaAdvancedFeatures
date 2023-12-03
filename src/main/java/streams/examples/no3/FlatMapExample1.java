package streams.examples.no3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample1 {
    public static void main(String[] args) {
        // Example 1. converting nested lists into a list
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        List<Integer> list3 = List.of(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(l -> l.stream()) // Stream<Integer>
                .collect(Collectors.toList());

        System.out.println(listOfAllIntegers);


        // Example 2. Coverting nested arrays into list
        String[][] dataArray = new String[][] {{"a","b"}, {"c","d"}, {"e", "f"}, {"g", "h"}};

        List<String> listOfAllStrings = Arrays.stream(dataArray) // Stream<String[]>
                .flatMap(a -> Arrays.stream(a)) // Stream<String>
                .collect(Collectors.toList());

        System.out.println(listOfAllStrings);

    }
}
