package nested_class;

public class Main {
    public static void main(String[] args) {
        Bicycle myBike = new Bicycle();

        System.out.println(myBike.getMaxSpeed()); // 40

        // weird way of instantiating an inner class
        // there is no point of instantiating an inner class
        Bicycle.Wheel aWheel = myBike.new Wheel();
        aWheel.slowDown();

        // instantiating static inner class
        Bicycle.StaticInnerClass myInnerClass = new Bicycle.StaticInnerClass();
        myInnerClass.doNothing();
    }
}
