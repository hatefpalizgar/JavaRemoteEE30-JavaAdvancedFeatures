package functional_programming.buit_in_jdk_func_interfaces;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {


        Supplier<Person> personSupplier = () -> new Person("Rio", 29);


        Person rio = personSupplier.get();
        Person rio2 = personSupplier.get();

        System.out.println(rio.getName());
        System.out.println(rio.getAge());

        /**
        * Next:
         * @see FunctionExample
        * */
    }
}
