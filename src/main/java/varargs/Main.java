package varargs;

public class Main {
    public static void main(String[] args) {
        int number = 10;

        displaySingleNumber(number);

        // What if I had two integers and wanted to display them?
        int a = 4;
        int b = 8;
        // 1. put two integers into an array and then call the display() method
        int[] twoNumbersArray = new int[]{a, b};
        display(twoNumbersArray);

        // 2. to create a new method that accepts two int arguments
        displayTwoNumbers(a, b);

        // 3. using ´varargs' OR ´variable arguments´
        displayByVarargs();
        displayByVarargs(a);
        displayByVarargs(a, b);
        displayByVarargs(a, b, 45, 56, 8954, 689);

        // Use varargs when you're not sure how many method arguments will be passed to the method
        // OR you want to provide more flexibility in the number of arguments you provide
    }

    public static void displayByVarargs(int...numbers) {
        // code here
    }

    public static void displaySingleNumber(int number) {
        // code here
    }

    public static void displayTwoNumbers(int first, int second) {
        // code here
    }

    public static void display(int[] numbers) {
        // code here
    }
}
