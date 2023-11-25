package functional_programming.buit_in_jdk_func_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        Consumer<Person> personConsumer = (person) -> {
            System.out.println(person.getName());
            System.out.println(person.getAge());
        };

        Person mary = new Person("Mary", 22);

        personConsumer.accept(mary);

        Consumer<String> stringConsumer = (str) -> System.out.println(str.toUpperCase());
        stringConsumer.accept("Hello World");

        List<Person> list = new ArrayList<>();
        list.add(new Person("Toby", 35));
        list.add(new Person("Rose", 20));
        list.add(new Person("Tom", 31));

        // forEach(...) below iterates through the list and for each Person object
        // it passes that Person object to the personConsumer as the input argument
        // and subsequently calls it's accept method
        list.forEach(personConsumer);

        /**
         * Next:
         * @see SupplierExample
         * */
    }
}
