package streams.examples.no3;

import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExample2 {
    public static void main(String[] args) {
        Developer d1 = new Developer();
        d1.setName("Tom");
        d1.addBook("Java 8 in action");
        d1.addBook("Spring Boot in action");
        d1.addBook("Effective Java (3rd Edition)");

        Developer d2 = new Developer();
        d2.setName("Edward");
        d2.addBook("Learning Python");
        d2.addBook("Effective Java (3rd Edition)");

        List<Developer> list = List.of(d1, d2);

        // using regular map() leads to complicated structures like List<Set<T>>
        List<Set<String>> collect = list.stream()           // Stream<Developer>
                .map(d -> d.getBooks())                     // Stream<Set<String>>
                .collect(Collectors.toList());

      Set<String> books = list.stream()                                           // Stream<Developer>
                .map(d -> d.getBooks())                         // Stream<Set<String>>
                .flatMap(set -> set.stream())                   // Stream<String>
                .filter(book -> !book.contains("Python"))       // filter python book
                .collect(Collectors.toSet());

        System.out.println(books);

        /*
         * More examples: https://mkyong.com/java8/java-8-flatmap-example/
         */
    }
}

class Developer {
    private String name;
    private Set<String> books;

    public void addBook(String book) {
        if (this.books == null) {
            this.books = new HashSet<>();
        }
        this.books.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBooks() {
        return books;
    }

    public void setBooks(Set<String> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Developer{" +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}