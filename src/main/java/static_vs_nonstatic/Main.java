package static_vs_nonstatic;

// Static variables and methods are created even before the class is loaded and object is created.
// Thus, we can access the static variables and methods from anywhere in the program.
// BUT, non-static variables and methods are created only when the class is loaded and object is created.
// Thus, we can access the non-static variables and methods only from within the non-static context.
// For example, inside calculateSalary() which is a static method, we can't access the non-static variables and methods.
// BUT, we can access calculateSalary() or company field from inside display() method
public class Main {
    public static void main(String[] args) {
        NonStaticEmployee emp1 = new NonStaticEmployee("John Wickers", 1001, "SDA");
        NonStaticEmployee emp2 = new NonStaticEmployee("Robert Barnes", 1002, "SDA");
        emp1.display();
        emp2.display();

        System.out.println("======== Static field: Company =========");
        StaticEmployee emp3 = new StaticEmployee("John Wickers", 1001);
        StaticEmployee emp4 = new StaticEmployee("Robert Barnes", 1002);
        emp3.display();
        emp4.display();

        System.out.println("======== Static method: calculateSalary(...) =========");
        System.out.println("The salary for emp3: " + StaticEmployee.calculateSalary(1000, 0.2));
        System.out.println("The salary for emp4: " + StaticEmployee.calculateSalary(2000, 0.2));

        // Please learn more about static and non-static in Java here:
        // https://examples.javacodegeeks.com/static-vs-non-static-in-java/

    }
}
