package class_and_object;

public class Building {
    // properties, attributes, FIELDS
    private String name;
    private int numberOfFloors;
    private int numberOfRooms;

    // no-arg constructor
    public Building(){

    }

    // all-args constructor
    public Building(String name, int numberOfFloors, int numberOfRooms) {
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.numberOfRooms = numberOfRooms;
    }


    // getter method (accessor)
    public String getName() {
        return name;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    // setter method (mutator)
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        if (numberOfFloors == 0) {
            System.out.println("Number of floors can't be 0");
            return;
        }
        this.numberOfFloors = numberOfFloors;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
