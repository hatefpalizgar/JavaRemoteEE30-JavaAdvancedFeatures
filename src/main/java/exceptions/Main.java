package exceptions;

/* ========================================================================================== */
//                                  Exceptions in Java
/* ========================================================================================== */

// In Java, an exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions.
// Exceptions can be caused by various things, such as attempting to access a file that doesn't exist, trying to divide a number by zero,
// or attempting to access an element of an array with an index that is out of bounds.
// Exceptions are used to handle unusual or unexpected situations that may occur during the execution of a program.
// When an exception is thrown, it can be caught and handled by a specific block of code known as an "exception handler."
// This allows the program to continue running, rather than crashing or terminating.

// Exceptions are useful because they allow you to identify and handle potential problems in your code before they cause more serious issues.
// They also make it easier to debug and maintain your code, since you can add specific exception handling code to deal with specific types of exceptions that may be thrown.


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main1(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // what is the max index? 4
        System.out.println(arr[6]);  // this line THROWS ArrayIndexOutOfBoundsException
        System.out.println("This line never gets executed");
    }

    public static void main2(String[] args) {
        int a = 10;
        int b = 0;

        // try-catch block (exception handler)
        try {
            System.out.println(a / b);  // ArithmeticException: / by zero
            System.out.println("This line never gets executed");
        } catch (ArithmeticException ex) {
            System.out.println("Exception caught: " + ex);
        }

        System.out.println("This line will be printed");

    }

    /* ========================================================================================== */
    //                                  Exception Hierarchy
    /* ========================================================================================== */

    // https://rollbar.com/blog/java-exceptions-hierarchy-explained/
    // https://facingissuesonit.com/java-exception-handling/


    /* ========================================================================================== */
    //                            Checked vs. Unchecked Exceptions
    /* ========================================================================================== */
    // 4. Checked(compile-time) and unchecked(runtime) exceptions
    // 4.a. Checked exceptions are checked at compile time.
    // Classes that directly inherit Throwable except RuntimeException and Error e.g. IOException, InterruptedException
    // 4.b. Unchecked exceptions are not checked at compile time. Classes that inherit RuntimeException
    // are unchecked exceptions like ArithmeticException, NullPointerException, etc.


    /* ========================================================================================== */
    //                       Handling multiple exceptions using Pipe operator
    /* ========================================================================================== */

    public static void main3(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        try {
            System.out.println(arr[8]);  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | ArithmeticException ex) {
            System.out.println("Exception caught: " + ex);
        }
    }

    /* ========================================================================================== */
    //                       Handling multiple exceptions using multiple catch blocks
    /* ========================================================================================== */
    // Top to bottom, start by catching the most specific exception -> least specific exception
    public static void main4(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[2]);
            System.out.println(arr[1] / 0);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + ex);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException caught: " + ex);
        } catch (ArithmeticException ex) {
            System.out.println("ArithmeticException caught: " + ex);
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException caught: " + ex);
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex);
        }

        System.out.println("Hello World");
    }


    /* ========================================================================================== */
    //                                 How to throw exception
    /* ========================================================================================== */

    public static void main5(String[] args) {
        try {
            someMethod(false);
            System.out.println("Welcome to testing a washing machine");
        } catch (Exception ex) {
            ex.printStackTrace();  // prints the stack content in REVERSE order
        }

    }

    public static void someMethod(boolean isTurnedOn) throws Exception {
        if (isTurnedOn) {
            System.out.println("Washing machine is turned on");
        } else {
            System.out.println("Washing machine is turned off");
            throw new Exception("A turned off machine can't be tested");
        }
    }


    /* ========================================================================================== */
    //                                    Finally Block
    /* ========================================================================================== */

    public static void main6(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        try {
            System.out.println(arr[8]);  // IndexOutOfBoundsException
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            // whatever you put in finally block will ALWAYS execute, no matter the exception is handled or not
            System.out.println("I want this line to always run, no matter exception occurs or not");
        }

        System.out.println("This never prints anything");
    }

    /* ========================================================================================== */
    //                                    Custom Exceptions
    /* ========================================================================================== */

    public static void main7(String[] args) {
        aMethodThatThrowsCustomException();
    }

    // below I don't need to have 'throws PasswordNotFoundException' in method header
    // since, PasswordNotFoundException is a RuntimeException (unchecked)
    // so, compiler won't identify it
    public static void aMethodThatThrowsCustomException() {
        throw new PasswordNotFoundException("Password in invalid");
    }


    /* ========================================================================================== */
    //                                    Try with resources
    /* ========================================================================================== */
// https://www.baeldung.com/java-try-with-resources
    public static void main(String[] args) {

        // below try-with-resources block of code makes sure that any opened resources will be closed eventually.
        // here the resource is a file reader object. So no matter exception is handled or not, it will be closed and
        // would save system resources.
        try (FileReader fileReader = new FileReader("src/main/java/exceptions/Main.java")) {
            int c;
            while ((c = fileReader.read()) !=-1) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            System.out.println("Exception caught: " + e);
        }

    }

}
