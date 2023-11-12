package collections.maps.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Hatef", "Palizgar", 32);
        Person p2 = new Person("Adam", "Smith", 25);

        Friend f1 = new Friend("John", "Doe", 22);
        Friend f2 = new Friend("Mary", "Abraham", 40);

        Map<Person, Friend> map = new HashMap<>();
        Object obj =
        // add some entries to this map
        map.put(p1, f1);
        map.put(p2, f2);

        // add duplicate key - new entry will overwrite the previous entry
        // map.put(p1,f2);
        for (Map.Entry<Person, Friend> entry : map.entrySet()) {
            System.out.println("person: " + entry.getKey().toString() + " friend: " + entry.getValue().toString());
        }

        System.out.println(map.get(p1)); // prints f1
        System.out.println(map.containsKey(p1)); // true

        for (Friend value : map.values()) {
            System.out.println(value);
        }


        Map<Person, List<Friend>> partyPeople = new HashMap<>();
        partyPeople.put(p1, List.of(f1, f2));
        partyPeople.put(p2, List.of(f1, f2));

        for (Map.Entry<Person, List<Friend>> entry : partyPeople.entrySet()){
            for (Friend f: entry.getValue()) {
                System.out.println(entry.getKey().getFirstname() + ": \n" + f.getFirstname() + " " + f.getLastname()+ " " + f.getAge());
            }
        }

        // TODO: What would happen if we tried to sort the keys in this map or we were to use TreeMap?
        // How would entries be sorted in that TreeMap?
        // TODO: What is Comparable? What is Comparator? How they are different?
        // TODO: How we could tell Java how to sort Person objects? (take for example sort them by their age value)
    }
}
