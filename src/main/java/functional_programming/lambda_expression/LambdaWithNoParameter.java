package functional_programming.lambda_expression;

public class LambdaWithNoParameter {
    public static void main(String[] args) {
        // Lambda expression/function with no parameter/argument
        SayHelloFunctionalInterface msg = () -> {
            return "Hello World";
        };

        System.out.println(msg.sayHello());

        // How it was prior to lambda/Java8
        SayHelloFunctionalInterface msgOld = new SayHelloFunctionalInterface() {
            @Override
            public String sayHello() {
                return "Hello World";
            }
        };


        // I can make above lambda expression even easier to write/read
        // If your lambda expression contains one line (one-liner) you can remove curly braces and the return statement
        SayHelloFunctionalInterface msgImproved = () -> "Hello World";

        System.out.println(msgImproved.sayHello());


        /**
         * Next:
         * @see LambdaWithSingleParameter
         * */

    }
}


@FunctionalInterface
interface SayHelloFunctionalInterface {
    // an abstract method with no input argument
    String sayHello();
}