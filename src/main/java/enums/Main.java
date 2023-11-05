package enums;

import static enums.SimpleUnit.CENTIMETER;
import static enums.Weekday.FRIDAY;


public class Main {
    public static void main(String[] args) {
        String name = "John";

        SimpleUnit unit = CENTIMETER;

        ComplexUnit complexUnit = ComplexUnit.INCH;

        double heightInMeter = 1000 * complexUnit.convertToMeters();
        System.out.println(heightInMeter + " in meters"); // 25.4 meters

        // convert 500 grams to kilograms
        double gramsInKilograms = convertToKilograms(Weight.GRAM, 500);

        // Goal of enum:
        // Let's say you have an application that only accepts a predefined(default) set of colors
        // like red, blue, green
        // Using enum you enforce developers and users no to have any other colors

        System.out.println(Color.BLUE); // BLUE

       // Task:
        // Write an application that prints weekdays using enums
        // Also display their corresponding day number (Monday = 1 and so on)
        System.out.println(FRIDAY);  // FRIDAY
        System.out.println(FRIDAY.order); // 5
        System.out.println(FRIDAY.name()); // FRIDAY
        System.out.println(FRIDAY.ordinal()); // 4


        // TODO: Write an application for a traffic light (TrafficLight) that has RED,GREEN, YELLOW with
        //  some message to tell the drivers what to do
        //  Simulate a scenario of red light is turned on
        //  Show the driver the message

    }


    public static double convertToKilograms(Weight weight, double amount) {
        return amount * weight.valueInKilograms;
    }

}
