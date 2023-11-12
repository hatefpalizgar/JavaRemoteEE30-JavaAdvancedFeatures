package generics;

// 'T extends Vehicle' means T can ONLY be Vehicle or any subclass of Vehicle
// Technically, we are parameterizing Garage class over T
public class Garage<T extends Vehicle> {
    private T vehicle;

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }

    public void repairVehicle() {
        vehicle.repair();
    }
}
