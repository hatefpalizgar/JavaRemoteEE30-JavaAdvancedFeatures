package composition;

// Composition is a stricter form of aggregation
// It occurs when two classes you associate are mutually dependent and can't exist without each other.
// For example, take a Car and an Engine class:
// A Car cannot run without an Engine, while an Engine also cannot function without being built into a Car.
// This kind of relationship between objects is also called a PART-OF relationship.
// In PART-OF (composition), if one class stops to exist, the other cannot survive alone.

public class Building {
    private String address;
    private Door door;
    private Parking parking;

    public Building(String address, Door door, Parking parking) {
        this.address = address;
        this.door = door;
        this.parking = parking;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
