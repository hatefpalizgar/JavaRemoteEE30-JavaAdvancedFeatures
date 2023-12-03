### Task 1: Filtering and Mapping a List

You have a list of Employee objects, each containing their `name`, `salary`, and `department`. You need to find all employees whose `salary` is greater than 5000 and belong to the "Sales" `department`. Then, you need to map each of these employees to their `name` as a string and store the result in a new list.

Write a Java method that takes in a `List<Employee>` and returns a `List<String>` that contains the names of all employees who belong to the "Sales" department and have a salary greater than 5000.

Solution:

```java
public class Task1 {
public List<String> filterAndMap(List<Employee> employees) {
    List<String> result = employees.stream()
            .filter(e -> e.getSalary() > 5000 && e.getDepartment().equals("Sales"))
            .map(Employee::getName)
            .collect(Collectors.toList());
    return result;
    }
}
```




---
### Task 2: Grouping and Counting by a Field

You have a list of `Employee` objects, each containing their `name`, `salary`, and `department`. You need to group the employees by their `department` and count the number of employees in each department.

Write a Java method that takes in a `List<Employee>` and returns a `Map<String, Long>` where the key is the name of the department and the value is the number of employees in that department.

Solution:
```java
public class Task2 {
    public Map<String, Long> groupAndCount(List<Employee> employees) {
        Map<String, Long> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        return result;
    }
}
```





---
### Task 3: Reducing a List to a Single Object

You have a list of Student objects, each containing their name, age, and grade. You need to find the student with the highest grade and return their name as a String.

Write a Java method that takes in a List<Student> and returns a String containing the name of the student with the highest grade.

Solution:

```java
public class Task3 {
    public String findTopStudent(List<Student> students) {
        String result = students.stream()
                .max(Comparator.comparing(Student::getGrade))
                .map(Student::getName)
                .orElse("No student found");
        return result;
    }
}
```



---
### Task 4: Sorting a List
You have a list of Product objects, each containing their name, price, and quantity in stock. You need to sort the products by their price in descending order, then by their name in ascending order, and return a new sorted list.

Write a Java method that takes in a List<Product> and returns a new List<Product> containing the sorted products.

Solution:
```java
class Task4 {
    public List<Product> sortProducts(List<Product> products) {
        List<Product> result = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed()
                        .thenComparing(Product::getName))
                .collect(Collectors.toList());
        return result;
    }
}
```




---
### Task 5: Grouping and Counting
You have a list of Transaction objects, each containing their id, type, and amount. You need to group the transactions by their type, count the number of transactions for each type, and return a Map<String, Long> containing the type as the key and the count as the value.

Write a Java method that takes in a List<Transaction> and returns a Map<String, Long> containing the transaction types as the keys and the count of transactions for each type as the values.

Solution:
```java
public class Task5 {
    public Map<String, Long> groupTransactionsByType(List<Transaction> transactions) {
        Map<String, Long> result = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType, Collectors.counting()));
        return result;
    }
}
```




---
### Task 6: Filtering and Mapping

You have a list of Order objects, each containing their id, items, and total price. You need to filter out the orders where the total price is less than $50, then map the remaining orders to their id and total price, and return a new list of OrderSummary objects.

Write a Java method that takes in a List<Order> and returns a List<OrderSummary> containing the filtered and mapped orders.

> Hint: Below is the OrderSummary object code:
> ```java
> public class OrderSummary {
>  private int id;
>  private double totalPrice;
>     // constructor
>     // getters and setters and toString()
> }
> ```

Solution:
```java
public class Task6 {
    public List<OrderSummary> filterAndMapOrders(List<Order> orders) {
        List<OrderSummary> result = orders.stream()
                .filter(order -> order.getTotalPrice() >= 50.00)
                .map(order -> new OrderSummary(order.getId(), order.getTotalPrice()))
                .collect(Collectors.toList());
        return result;
    }
}
```




---
### Task 7: User Statistics
You have a list of User objects that contain a name, age, and a list of friends(list of strings). Your task is to find the top 3 users with the most number of friends, and return their names in a list. Implement this using Java Streams.

Solution:
```java
public class Task7 {

    public List<String> getTopUsersWithMostFriends(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(
                        user -> user.getFriends().size(),
                        Comparator.reverseOrder())
                )
                .limit(3)
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
```




---
### Task 8: Parallel Stream Processing
You have a large list of integers and you need to compute the sum of their squares. Implement this using parallel streams to take advantage of multi-core processors and speed up the computation.

Solution:
```java
public class Task8 {
    public int parallelStreamProcess(List<Integer> numbers) {
        return numbers.parallelStream()
                .mapToInt(n -> n * n)
                .sum();
    }
}
```




---
### Task 9: FlatMap
You have a list of orders placed by customers, and each order contains a list of items. Your task is to create a stream of all the items in all the orders.
#### class definitions:
```java
public class Order {
    private int orderId;
    private List<Item> items;
    
    // constructor, getters, and setters
}

public class Item {
    private int itemId;
    private String name;
    private int quantity;
    private double price;
    
    // constructor, getters, and setters
}
```

Solution:

```java
public class Task9 {
    public List<Item> findAllItems(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.toList());
    }
}
```




---
### Task 10: Filtering and Mapping Nested Collections
You have a list of `Person` objects, each of which has a name and a list of addresses. Each `address` has a street, a city, and a state. Your task is to create a list of all the cities where people with the name "John" live, using Java Streams.


Solution:
```java
public class Task10 {
    public List<String> findCitiesOfJohns(List<Person> people) {
        return people.stream()
                .filter(person -> person.getName().equals("John"))
                .flatMap(person -> person.getAddresses().stream())
                .map(Address::getCity)
                .collect(Collectors.toList());
    }
}
```