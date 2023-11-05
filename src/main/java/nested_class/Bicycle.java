package nested_class;

/* ========================================================================================== */
//                                    Inner Class
/* ========================================================================================== */
/*
 * In Java, it is possible to declare classes inside other classes.
 * We call these classes nested classes. They can be declared as:
 *  1. static classes (so-called static nested), using the static keyword
 *  2. non-static classes (so-called non-static or inner)
 *
 * Please refer to Journey for reading about 'inner classes'
 */

public class Bicycle {
    private int maxSpeed = 40;

    public int getMaxSpeed() {
        return maxSpeed;
    }

   public class Wheel {
        public void slowDown() {
            // we can refer(access) to outer class's fields/methods
            maxSpeed *= 0.5;
            System.out.println("Wheel's max speed is now: " + maxSpeed);
        }
   }// end of Wheel class (inner class)

   public static class StaticInnerClass {
        public void doNothing() {
            System.out.println("I am a static inner class method");
        }
   }// end of StaticInnerClass

}// end of Bicycle class (outer class)
