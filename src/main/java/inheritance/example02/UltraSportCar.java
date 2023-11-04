package inheritance.example02;

public class UltraSportCar extends Car{
    // UltraSportCar is a Car

    private String nitrogenType;

    public UltraSportCar(String model, String nitrogenType) {
        super(model);
        this.nitrogenType = nitrogenType;
    }

    @Override
    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() --> UltraSportCar");
    }

    public String getNitrogenType() {
        return nitrogenType;
    }
}
