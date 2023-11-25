package functional_programming.lambda_expression;

public class LambdaWithSingleParameter {
    public static void main(String[] args) {


        IncrementFunctionalInterface f = (int num) -> {
          return num + 5;
        };

        // If your lambda expression/function takes only one single parameter/argument
        // you can remove the parenthesis around the input argument
        IncrementFunctionalInterface g = num -> num + 7;


        System.out.println(f.increment(10));  // 10 + 5 = 15

        System.out.println(g.increment(22)); // 22 + 7 = 29


        // Functions are the first-class citizens in a functional programming world

        /**
         * Next:
         * @see LambdaWithMultipleParameters
         * */

    }
}


@FunctionalInterface
interface IncrementFunctionalInterface {
    // an abstract method with one argument
    int increment(int num);
}