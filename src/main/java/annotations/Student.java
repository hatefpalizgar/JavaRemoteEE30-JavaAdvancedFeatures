package annotations;

import java.lang.reflect.Method;
import java.time.Month;

public class Student {

    private String firstname;
    private String lastname;
    private int age;

    public Student(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

    @MyCustomAnnotation(value = {"first", "second"})
    @Deprecated
    public void methodWithAnnotation(@Deprecated int someNumber) {
        // ...
    }

    // now let's see how we can process @MyCustomAnnotation
    public void processMyCustomAnnotation(){
        // We are using Reflection API to get the method with @MyCustomAnnotation
        // Reflection API is a powerful tool that allows us to get information about the class, methods, fields, etc.
        // It's a bit more advanced tool and needs a separate lecture to understand it BUT
        // you rarely need to use it in your projects, and it would be a bit risky to use it in your projects
        // if you don't know how to use it properly. So let's skip it for now.
        Method[] methods = this.getClass().getMethods();

        for(Method method: methods) {
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
                System.out.println(annotation.value()[0]);  // first
                System.out.println(annotation.value()[1]);  // second
            }
        }
    }

    public void processDeprecatedAnnotation() {
        Method[] methods = this.getClass().getMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Deprecated.class)) {
                System.out.println("Method " + method.getName() + " is deprecated");
            }
        }
    }

}
