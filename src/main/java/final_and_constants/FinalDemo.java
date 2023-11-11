package final_and_constants;

public class FinalDemo {
    public static void main(String[] args) {

        /* ========================================================================================== */
        //                                   Java final Variable
        /* ========================================================================================== */
        // In Java, we cannot change the value of a final variable.
        // Once a final variable is assigned, it always contains the same value.
        // If we try to change the value of a final variable, a compile-time error is generated.

        final int x = 100;

        // x = 200; // compile time error


        /* ========================================================================================== */
        //                                    Java final Class
        /* ========================================================================================== */
        // In Java, the final class cannot be inherited by another class.
//        class SubClass extends FinalClass {
//
//        }

        /* ========================================================================================== */
        //                                    Java final Method
        /* ========================================================================================== */
        // In Java, the final method cannot be overridden by the child class.

        class SubClass extends NonFinalClass{
//            @Override
//            public final void finalMethod() {
//                System.out.println("This is a final method");
//            }
        }


    }
}

final class FinalClass { // This class can't be subclassed/extended
}

class NonFinalClass {
    public final void finalMethod() {
        System.out.println("This is a final method");
    }
}