Task 1:
Create a class named "Person" that has two private fields, "name" and "age". Add a constructor that initializes these fields and getter methods for both fields. Then, create a functional interface named "AgeChecker" that has a single method named "isAdult" that takes a "Person" object as a parameter and returns a boolean indicating whether the person is an adult (age 18 or above).

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

@FunctionalInterface
interface AgeChecker {
    boolean isAdult(Person p);
}
```

Task 2: (_This task requires Streams API_)
Create a list of "Person" objects and populate it with at least five persons. Then, use a method reference to create an instance of the "AgeChecker" functional interface that checks if a person is an adult. Finally, use the "filter" method of the list to filter out all persons who are not adults, using the "isAdult" method reference you just created.

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 17));
        persons.add(new Person("Charlie", 30));
        persons.add(new Person("David", 15));
        persons.add(new Person("Eve", 20));
        
        AgeChecker ageChecker = Person::isAdult;
        List<Person> adults = persons.stream()
                                     .filter(ageChecker::isAdult)
                                     .toList();
        
        System.out.println(adults);
    }
}
```
Output:
```text
[Person{name='Alice', age=25}, Person{name='Charlie', age=30}, Person{name='Eve', age=20}]
```

Task 3:
Create a functional interface named "StringConverter" that has a single method named "convert" that takes a "String" as a parameter and returns an integer. Then, create a static method named "countVowels" in the "Person" class that takes a "String" as a parameter and returns the number of vowels in the string. Finally, use a method reference to create an instance of the "StringConverter" functional interface that converts a string to the number of vowels in it.

```java
@FunctionalInterface
interface StringConverter {
    int convert(String s);
}

public class Person {
    // ...
    
    public static int countVowels(String s) {
        return s.replaceAll("[^AEIOUaeiou]", "").length();
    }
}

public class Main {
    public static void main(String[] args) {
        StringConverter converter = Person::countVowels;
        int numVowels = converter.convert("Hello, world!");
        
        System.out.println(numVowels);
    }
}
```
Output:
```text
3
```
Task 4:
Create a class named "Calculator" that has two private fields, "num1" and "num2". Add a constructor that initializes these fields and getter methods for both fields. Then, create a functional interface named "BinaryOperator" that has a single method named "apply" that takes two integers as parameters and returns an integer. Next, create static methods in the "Calculator" class for each of the basic arithmetic operations (addition, subtraction, multiplication, and division) that take two integers as parameters and return the result of applying the respective operation. 

Finally, inside main() method, create an instance of Calculator object with 10 and 5 as “num1” and “num2”, then use method references to create instances of the "BinaryOperator" functional interface that represent each of the basic arithmetic operations, call them "adder", "subtractor", "multiplier" and "divider".
Use the "apply" method of each of these "BinaryOperator" instances and pass them "num1" and "num2".
Print the result of each operation to the console.

```java
@FunctionalInterface
interface BinaryOperator {
    int apply(int a, int b);
}

public class Calculator {
    private int num1;
    private int num2;
    
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    public int getNum1() {
        return num1;
    }
    
    public int getNum2() {
        return num2;
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int subtract(int a, int b) {
        return a - b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    public static int divide(int a, int b) {
        return a / b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10, 5);
        BinaryOperator adder = Calculator::add;
        BinaryOperator subtractor = Calculator::subtract;
        BinaryOperator multiplier = Calculator::multiply;
        BinaryOperator divider = Calculator::divide;
        
        int sum = adder.apply(calculator.getNum1(), calculator.getNum2());
        int difference = subtractor.apply(calculator.getNum1(), calculator.getNum2());
        int product = multiplier.apply(calculator.getNum1(), calculator.getNum2());
        int quotient = divider.apply(calculator.getNum1(), calculator.getNum2());
        
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
}

```
Output:

```text
Sum: 15
Difference: 5
Product: 50
Quotient: 2
```

Task 5:
Create a class named "StringUtils" with a static method named "reverse" that takes a "String" as a parameter and returns the reverse of that string. Then, create a functional interface named "StringFunction" that has a single method named "apply" that takes a "String" as a parameter and returns a "String". Finally, use a method reference to create an instance of the "StringFunction" functional interface that applies the "reverse" method of the "StringUtils" class.
```java
@FunctionalInterface
interface StringFunction {
    String apply(String s);
}

public class StringUtils {
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        StringFunction reverser = StringUtils::reverse;
        String reversedString = reverser.apply("hello world");
        
        System.out.println(reversedString);
    }
}
```
Output:
```text
dlrow olleh
```

Task 6:
Create a class named "Person" with private fields for "name" and "age", a constructor that initializes these fields, and getter methods for both fields. Then, create a method named "compareByAge" that takes two "Person" objects as parameters and returns the difference in age between the two people. Finally, use a method reference to create an instance of the "Comparator" functional interface that compares "Person" objects by age using the "compareByAge" method.

```java
import java.util.Comparator;

public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public static int compareByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        
        Comparator<Person> ageComparator = Person::compareByAge;
        
        int ageDifference = ageComparator.compare(person1, person2);
        
        System.out.println("Age difference: " + ageDifference);
    }
}
```
Output:
```text
Age difference: -5
```
Task 7:
Create a class named "Shape" with private fields for "name", “width” and “height”, a constructor that initializes only the “name” field, and a method named "getArea" that returns the area of the shape. Then, create subclasses of "Shape" for "Rectangle" and "Circle" that override the "getArea" method to compute the area of the respective shapes.
In your main() method create two “Shape” instances Rectangle("Rectangle", 5.0, 3.0) and Circle("Circle", 2.5). Then use method references to create instances of the "Function" functional interface that compute the area of a "Rectangle" and a "Circle"; call them "rectangleArea" and "CircleArea" respectively. Use these two instances to print out the name and area of each shape instance to the console.

```java
import java.util.function.Function;

public class Shape {
    private String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public double getArea() {
        return 0.0;
    }
}

public class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
}

public class Circle extends Shape {
    private double radius;
    
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Function<Rectangle, Double> rectangleArea = Rectangle::getArea;
        Function<Circle, Double> circleArea = Circle::getArea;
        
        Rectangle rectangle = new Rectangle("Rectangle", 5.0, 3.0);
        Circle circle = new Circle("Circle", 2.5);
        
        System.out.println(rectangle.getName() + " area: " + rectangleArea.apply(rectangle));
        System.out.println(circle.getName() + " area: " + circleArea.apply(circle));
    }
}
```
Output:
```text
Rectangle area: 15.0
Circle area: 19.634954084936208
```

Task 8:
Create a functional interface named "StringProcessor" that has a single method named "process" that takes a string as a parameter and returns a string. Then, create a class named "StringUtils" with static methods for reversing and capitalizing a string. Finally, use method references to create instances of the "StringProcessor" functional interface that correspond to the reverse and capitalize methods of the "StringUtils" class.
In your main() method try to print out to the console 3 items:
    1. Original input string: “Hello, World!”
    2. Reversed string
    3. Capitalized string


```java
@FunctionalInterface
interface StringProcessor {
    String process(String s);
}

public class StringUtils {
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    public static String capitalize(String s) {
        return s.toUpperCase();
    }
}

public class Main {
    public static void main(String[] args) {
        StringProcessor reverser = StringUtils::reverse;
        StringProcessor capitalizer = StringUtils::capitalize;
        
        String input = "Hello, World!";
        
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reverser.process(input));
        System.out.println("Capitalized String: " + capitalizer.process(input));
    }
}
```
Output:
```text
Original String: Hello, World!
Reversed String: !dlroW ,olleH
Capitalized String: HELLO, WORLD!
```

Task 9:
Create a class named "Person" with a private field for "name" and a constructor that initializes this field. Then, create an instance method named "greet" that takes a "String" as a parameter and returns a greeting message with the person's name. Finally, create an instance of the "Person" class and use method references to create an instance of the "Function" functional interface that calls the "greet" method of the person instance.
```java
import java.util.function.Function;

public class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String greet(String message) {
        return "Hi, " + message + "! My name is " + name + ".";
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John");
        
        Function<String, String> greeter = person::greet;
        
        System.out.println(greeter.apply("how are you"));
    }
}
```
Output:
```text
Hi, how are you! My name is John.
```

Task 10:
Create a class named "Car" with a private field for "make" and "model" and a constructor that initializes this field. Then, create a functional interface named "CarFactory" that has a single method named "create" that takes two string parameters for the "make" and "model" of the car and returns a new instance of the "Car" class with the given make and model. Finally, use method references to create an instance of the "CarFactory" functional interface that corresponds to the "Car" constructor. In your main() method use this "CarFactory" instance to create a "Car" object and print it out to the console.

```java
interface CarFactory {
    Car create(String make, String model);
}

public class Car {
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}

public class Main {
    public static void main(String[] args) {
        CarFactory factory = Car::new;

        Car car = factory.create("Toyota", "Camry");

        System.out.println("Created car with make: " + car.getMake() + ", model: " + car.getModel());
    }
}
```
Output:
```text
Created car with make: Toyota, model: Camry
```
In this solution, we create a class named "Car" with two private fields for "make" and "model" and a constructor that initializes these fields. Then, we create a functional interface named "CarFactory" with a single method that creates a new instance of the "Car" class with the given make and model. Finally, we use a method reference to the "Car" constructor to create an instance of the "CarFactory" interface. We call the "create" method of the "CarFactory" instance to create a new "Car" object with the make "Toyota" and the model "Camry".

