package functional_programming.buit_in_jdk_func_interfaces;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        Checker<String> javaChecker = (message) -> message.contains("Java");

        boolean isAJavaDeveloper = javaChecker.check("John is a Java developer");
        System.out.println(isAJavaDeveloper);  // true

        Checker<Person> lab = p -> p.getAge() > 30;

        Person john = new Person("John", 24);
        boolean result = lab.check(john);
        System.out.println(result); // false

        // Let's see an example of the built-in Predicate<T>
        Predicate<Person> pr = person -> person.getName().contains("h");

        System.out.println(pr.test(john));  // true
    }
}

@FunctionalInterface
interface Checker<T> {
    boolean check(T input);
}