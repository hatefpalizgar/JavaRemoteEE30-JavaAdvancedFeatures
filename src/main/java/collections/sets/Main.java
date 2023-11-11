package collections.sets;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Set is an interface, thus if you want to get a Set instance,
        // you need its implementation. Here we are using HashSet.
        Set<String> travelRoute = new HashSet<>();
        travelRoute.add("Berlin");
        travelRoute.add("Tallinn");
        travelRoute.add("Paris");
        travelRoute.add("London");
        travelRoute.add("Paris");
        travelRoute.add("Tallinn");

        travelRoute.remove("London");

        for(String city: travelRoute) {
            System.out.println(city);
        }

        /* ============================================================================================== */
        //                              Union, Intersection, Difference
        /* ============================================================================================== */
        Set<Integer> a = new HashSet<>();
        a.addAll(Arrays.asList(1, 3, 2, 4, 8, 9, 0));

        Set<Integer> b = new HashSet<>();
        b.addAll(Arrays.asList(1, 3, 7, 5, 4, 0, 7, 5));

        // To find Union of two sets, we can use the following method:
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union of two sets: " + union);

        // Intersection: returns a new set containing all elements that are common to both sets
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection of two sets: " + intersection);

        // Difference: returns a new set containing all elements that are in the first set but not in the second set
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference of two sets: " + difference);

        /* ============================================================================================== */
        //                                 HashSet, EnumSet, LinkedHashSet, TreeSet
        /* ============================================================================================== */
        // 1. HashSet: does not guarantee order of elements. It is a good choice for storing elements that are not ordered.
        // 2. EnumSet: is a set of elements of a specific enum type. High-performance and faster than HashSet.
        Set<Days> enumSet = EnumSet.of(Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY);
        System.out.println("enumset: " + enumSet);

        // 3. LinkedHashSet: is a set that maintains the order of elements in which they were inserted.
        // When iterating through a HashSet, the order is unpredictable, while a LinkedHashSet lets us
        // iterate through the elements in the order in which they were inserted.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("India");
        linkedHashSet.add("Australia");
        linkedHashSet.add("South Africa");
        // adding a duplicate element
        linkedHashSet.add("India");

        System.out.println("linkedHashSet: " + linkedHashSet);

        Iterator<String> iterator = linkedHashSet.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 4. TreeSet: it behaves like a simple set with the exception that it stores element in a sorted format.
        // It is a good choice for storing elements that are ordered and sorted.
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("India");
        treeSet.add("Australia");
        treeSet.add("South Africa");
        treeSet.add("India");
        System.out.println("treeSet: " + treeSet);


        // TODO: To learn more: https://www.geeksforgeeks.org/set-in-java/?ref=lbp

    }
}

