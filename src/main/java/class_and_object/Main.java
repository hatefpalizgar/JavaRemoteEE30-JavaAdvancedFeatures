package class_and_object;

public class Main {
    public static void main(String[] args) {
        // Let's create two instances of the class Building called building1 and building2
        // The process of creating objects is called 'instantiation'
        Building building1 = new Building("building1", 4, 2);
        System.out.println(building1.getName());
        System.out.println(building1.getNumberOfFloors());
        System.out.println(building1.getNumberOfRooms());

        Building building2 = new Building("building2", 5, 3);
        building2.setName("Tom's building");
        building2.setNumberOfFloors(0);
        System.out.println(building2.getNumberOfFloors());  // 5
    }
}
