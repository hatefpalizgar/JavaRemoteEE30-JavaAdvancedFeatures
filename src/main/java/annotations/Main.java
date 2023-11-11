package annotations;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John", "Smith", 23);
        student.methodWithAnnotation(11);

        student.processMyCustomAnnotation();  // first second
        student.processDeprecatedAnnotation(); // Method methodWithAnnotation is deprecated
    }
}
