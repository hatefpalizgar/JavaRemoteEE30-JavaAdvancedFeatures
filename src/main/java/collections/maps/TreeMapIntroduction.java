package collections.maps;

//  A TreeMap is a Map implementation in Java that maintains its entries in ascending order, sorted according to the keys' natural ordering
//  or according to a Comparator provided at the time of the TreeMap's creation.

//  TreeMap has the following characteristics:
//      - It is a sorted map, meaning that the keys are ordered according to their natural ordering or a specified Comparator.
//      - It does not allow null keys, but it does allow null values.
//      - It provides efficient access to the entries based on their keys, as well as efficient range queries (queries for a range of keys).

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapIntroduction {
    public static void main(String[] args) {
        System.out.println("================== TreeMap with default Comparator ===============");
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2, 200);
        treeMap.put(4, 400);
        treeMap.put(1, 100);
        treeMap.put(3, 300);

        // Null keys are not allowed in TreeMap
        //treeMap.put(null, 700);

        System.out.println(treeMap);

        System.out.println("================== TreeMap with built-in Comparator ===============");
        treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.put(2, 200);
        treeMap.put(4, 400);
        treeMap.put(1, 100);
        treeMap.put(3, 300);

        System.out.println(treeMap);


        System.out.println("================== TreeMap with custom Comparator ===============");
        Map<String, Integer> unsortedMap = new HashMap<>();
        // Add some key-value pairs to the map
        unsortedMap.put("banana", 2);
        unsortedMap.put("apple", 10);
        unsortedMap.put("cherry", 3);

        // Print the map (unsorted)
        System.out.println("Original map: " + unsortedMap);

        Map<String, Integer> sortedMap = new TreeMap<>(new ValueComparator(unsortedMap));

        sortedMap.putAll(unsortedMap);  // it will be sorted based on ValueComparator logic

        System.out.println("Sorted map: " + sortedMap);

    }
}

// A comparator that compares the values of the map not the keys which is the default behaviour
class ValueComparator implements Comparator<String> {
    Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(String key1, String key2) {
        int value1 = map.get(key1);
        int value2 = map.get(key2);
        return value1 - value2;
    }
}