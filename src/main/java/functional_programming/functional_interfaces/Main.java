package functional_programming.functional_interfaces;

public class Main {
    public static void main(String[] args) {

//        Printable printable = new Printable() {
//            @Override
//            public void print(String message) {
//                System.out.println(message);
//            }
//        };
//
//        printable.print("Hello World");


        // Lambda Token   ->
        // Left side of token: list all the inputs(arguments) to the SINGLE ABSTRACT method
        // Right side of token: the body of the method (with/without return statement)
        Printable printable = (String message) -> {
            System.out.println(message);
        };

        printable.print("Hello World");


        /**
         * Next:
         * @see functional_programming.lambda_expression.LambdaWithNoParameter
         * */
    }
}
