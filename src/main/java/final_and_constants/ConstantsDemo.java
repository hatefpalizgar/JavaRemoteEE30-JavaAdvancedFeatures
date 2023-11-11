package final_and_constants;
/**
 * The {@code ConstantsDemo} class demonstrates the use of constants in Java.
 * Constants in Java are variables whose values cannot be changed once they are initialized,
 * typically declared with the {@code final} keyword. Constants are useful for defining values
 * that remain constant throughout the execution of a program.
 *
 * <p>Constants are particularly useful for storing configuration values such as database URLs,
 * maximum number of login attempts, or any other fixed values that should not be altered during
 * the execution of the program. They enhance the readability, maintainability, and safety of the code.
 *
 * <p>Key Points:
 * <ul>
 *     <li>Constants are declared with the {@code final} keyword and must be initialized at the time of declaration.</li>
 *     <li>Constants are usually named in uppercase letters, with underscores to separate words.</li>
 *     <li>Once assigned, the value of a constant cannot be changed.</li>
 *     <li>Constants can be local to a method or part of a class (using {@code static}).</li>
 *     <li>They are used to prevent accidental modification of critical values and facilitate code reuse.</li>
 * </ul>
 */
public class ConstantsDemo {

    // declaring a constant (static final)
    public static final double PI = 3.14159;

    // Constants for application configuration
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final int MAX_LOGIN_ATTEMPTS = 3;

    public static void main(String[] args) {
        // Usage of constants in a method
        System.out.println("Connecting to database: " + DATABASE_URL);
        for (int i = 1; i <= MAX_LOGIN_ATTEMPTS; i++) {
            System.out.println("Attempt " + i + " of " + MAX_LOGIN_ATTEMPTS);
            // Logic for login attempts goes here
        }

        // Below line causes compilation error
        // MAX_LOGIN_ATTEMPTS = 5;
    }
}
