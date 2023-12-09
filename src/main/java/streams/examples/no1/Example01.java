package streams.examples.no1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example01 {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 40);
        Employee jack = new Employee("Jack Hill", 39);
        Employee snow = new Employee("Snow White", 35);


        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);


        // Scenario: use Streams API to print the employees name in each department
        // first solution:
        departments.stream()  // Stream<Department>
                .map(department -> department.getEmployees())  // Stream<List<Employee>>
                .forEach( // for each list of employees 'list' do below
                        list -> list.forEach(e -> System.out.println(e.getName())));

        // second solution: instead of map() I'll use flatMap()
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(employee -> System.out.println(employee.getName()));



        List<Employee> employees = departments.stream()
                .flatMap(department -> department.getEmployees().stream())  // Stream<Employee>
                .collect(Collectors.toList());


        // use Streams API to create a Map<Integer, List<Employee>> that groups employees by their age e.g. [30 : {e1,e2,e3}]
        Map<Integer, List<Employee>> groupedByAge  = departments.stream()
                .flatMap(department -> department.getEmployees().stream())  // Stream<Employee>
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        // What is the goal of below code?
        // To print the name of the oldest employee
        // Answer: To print the name of the oldest employee
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2)
                .ifPresent(e -> System.out.println(e.getName()));


        /**
         * @see streams.examples.no2.Example02
         * */
    }
}
