package inheritance.example02;

public class Main {
    public static void main(String[] args) {
        Car aCar = new Car("Ford");
        System.out.println(aCar.getModel());  // Ford
        aCar.turnOnEngine();
        // aCar.boostSpeed();  Car is not a SportCar

        SportCar aSportCar = new SportCar("Porsche");
        System.out.println(aSportCar.getModel());  // Porsche
        aSportCar.turnOnEngine();  // any SportCar is also a Car
        aSportCar.boostSpeed();

        // Below is possible since any UltraSportCar is also a Car
        Car ultraSportCar = new UltraSportCar("Subaru", "Nitro-123");
        // ultraSportCar object is now bounded/limited to methods/fields available to Car objects
        // ultraSportCar.getNitrogenType();

        System.out.println("============ NO-POLYMORPHISM ============");
        UltraSportCar ferrari = new UltraSportCar("Ferrari", "Nitro-123");
        SportCar toyota = new SportCar("Toyota");

        igniteUltraEngine(ferrari);  // this method is unable to process 'toyota'
        igniteSportEngine(toyota);

        System.out.println("============ POLYMORPHISM ============");
        igniteCarEngine(ferrari);
        igniteCarEngine(toyota);

    }

    public static void igniteUltraEngine(UltraSportCar a) {
        a.turnOnEngine();
    }

    public static void igniteSportEngine(SportCar a) {
        a.turnOnEngine();
    }

    public static void igniteCarEngine(Car a){
        a.turnOnEngine();  // the behaviour of turnOnEngine() will be specified at runtime based on the exact type of 'a'
    }

}
