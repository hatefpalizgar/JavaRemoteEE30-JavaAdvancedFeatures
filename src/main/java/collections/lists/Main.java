package collections.lists;

import java.util.*;

public class Main {
    /* ============================================================================================== */
    //                                       List Interface
    /* ============================================================================================== */
    // Java List interface is a member of the Java Collections Framework.
    // List allows you to add duplicate elements.
    // List allows you to have ‘null’ elements
    // List interface got many default methods in Java 8, for example replaceAll(), sort() and spliterator().
    // List is an ordered collection of items. (it keeps the order of insertions)

    public static void main(String[] args) {
        String[] array = new String[10]; // array is fixed in size

        // Declaring an arraylist of Strings
        List<String> list = new ArrayList<>();  // size is dynamic

        // add elements to a list
        list.add("A");
        list.add("B");

        // remove element
        list.remove("A");

        // to get size of a list
        System.out.println(list.size()); // 1

        // check if a list is empty or not
        System.out.println(list.isEmpty());  // false

        // check if a list contains a specific element
        System.out.println(list.contains("B")); // true

        // remove all the elements of a list altogether
        list.clear();

        System.out.println(list.size()); // 0

        // add multiple elements to a list using addAll() method
        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        list2.add("A");

        // list.addAll(list2);  // first approach
        // second approach(ad-hoc)
        list.addAll(List.of("A", "B", "C", "D", "A"));

        // to get an element from a list
        System.out.println(list.get(1));  // B

        // replace an element in a list by index
        list.set(2, "T");

        // how to find the index of the first occurrence of an element in a list
        System.out.println(list.indexOf("A")); // 0

        // how to find the index of the last occurrence of an element in a list
        System.out.println(list.lastIndexOf("A")); // 4

        /* ============================================================================================== */
        //                               Java Array to List using `Arrays` class
        /* ============================================================================================== */

        // We can use Arrays class to get the view of array as list.
        // However, we won’t be able to do any structural modification to the list, it will throw java.lang.UnsupportedOperationException.


        String[] vowels = {"a", "e", "i", "o", "u"};

        List<String> vowelsList = Arrays.asList(vowels);
        System.out.println(vowelsList);

        /*
         * List is backed by array, we can't do structural modification
         * Both of the below statements will throw java.lang.UnsupportedOperationException
         */
        // vowelsList.remove("e");
        // vowelsList.clear();

        // So the best way is to use for loop for creating list by iterating over the array
        List<String> myList = new ArrayList<>();
        for (String s : vowels) {
            myList.add(s);
        }

        myList.remove("e");
        System.out.println(myList);  // "e" is removed without any exception


        /* ============================================================================================== */
        //                            Java List to array using toArray()
        /* ============================================================================================== */
        List<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");

        // convert list to array
        String[] strArray = new String[letters.size()];
        strArray = letters.toArray(strArray);
        System.out.println(Arrays.toString(strArray));


        /* ============================================================================================== */
        //                            List sort using sort()
        /* ============================================================================================== */
        // TODO: What is autoboxing? what is unboxing? what is casting?
        // int -> Integer double -> Double boolean -> Boolean
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(1000));
        }

        // integerList will be sorted based on natural ordering
        // TODO: what is natural ordering in Java?
        Collections.sort(integerList);
        System.out.println("Naturally sorted: " + integerList);

        /* ============================================================================================== */
        //                            List Iterator using iterator()
        /* ============================================================================================== */
        List<Integer> integerList2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integerList2.add(i);
        }

        // modify the list using iterator
        Iterator<Integer> iterator = integerList2.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            if (item % 2 == 0) iterator.remove();
        }

        System.out.println(integerList2);

        // TODO: There is another iterator class called ListIterator.
        //  Discover what extra functionality it provides and test some of them.


        /* ============================================================================================== */
        //                                       ArrayList
        /* ============================================================================================== */
        // ArrayList is a class that implements List interface.
        // ArrayList in Java is used to store dynamically sized collection of elements.
        // Contrary to Arrays that are fixed in size, an ArrayList grows its size automatically when new elements are added to it.
        // ArrayList internally uses an array to store the elements. Just like arrays, It allows you to retrieve the elements by their index.
        // ArrayList allows duplicate and null values.
        // ArrayList is an ordered collection. It maintains the insertion order of the elements.
        // ArrayList is not synchronized, therefore it's not thread-safe.
        List<String> animals = new ArrayList<>();
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Cat");
        animals.add("Dog");

        animals.add(2, "Elephant");

        System.out.println(animals);  // [Lion, Tiger, Elephant, Cat, Dog]

        // We can create an ArrayList from another collection using ArrayList(Collection c) constructor.
        List<Integer> firstTwoPrimeNumbers = new ArrayList<>();
        firstTwoPrimeNumbers.add(2);
        firstTwoPrimeNumbers.add(3);

        List<Integer> primeNumbers = new ArrayList<>(firstTwoPrimeNumbers);

        // We can add all elements from another collection using addAll(Collection c) method.
        List<Integer> nextTwoPrimeNumbers = new ArrayList<>();
        nextTwoPrimeNumbers.add(5);
        nextTwoPrimeNumbers.add(7);

        primeNumbers.addAll(nextTwoPrimeNumbers);

        System.out.println(primeNumbers);  // [2, 3, 5, 7]


        /* ============================================================================================== */
        //                                       LinkedList
        /* ============================================================================================== */
        // LinkedList is a linear data structure where the elements are not stored in contiguous locations
        // and every element is a separate object with a data part and address part.
        // The elements are linked using pointers or addresses.
        // Each element is known as a node.
        // It also has a few disadvantages like the nodes cannot be accessed directly instead we need to start from the head and follow through the link to reach a node we wish to access
        // LinkedLists are generally slower than Lists when it comes to accessing elements at a specific index, but they are faster at inserting and deleting elements in the middle of the list
        // As a rule of thumb: Use an ArrayList for storing and accessing data, and LinkedList to manipulate data.
        // Another difference between a LinkedList and a List is that LinkedLists have additional methods for manipulating the list,
        // such as addFirst() and addLast(), which allow you to insert elements at the beginning or end of the list.

        // List<String> linkedList = new LinkedList<>(List.of("element1", "element2", "element3"));
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("element1", "element2", "element3"));
        linkedList.addFirst("first item");
        linkedList.addLast("last item");


        /* ============================================================================================== */
        //                                       Interview Questions
        /* ============================================================================================== */
        // 1. What is the difference between ArrayList and LinkedList?
        // 2. How to sort an ArrayList of objects using custom comparator?
        // 3. How to synchronize concurrent modifications to an ArrayList? (Collections.synchronizedList() and CopyOnWriteArrayList)
        // 4. Which list implementation is better for READ-heavy operations? which one for WRITE-heavy operation?

    }
}
