package functional_programming.lambda_expression;

public class LambdaWithMultipleParameters {
    public static void main(String[] args) {

        StringConcatFunctionalInterface s = (str1, str2) -> str1 + str2;

        System.out.println(s.concat("Hello ", "World"));


    }
}

@FunctionalInterface
interface StringConcatFunctionalInterface {
    String concat(String a, String b);
}