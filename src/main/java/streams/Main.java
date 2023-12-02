package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Student a = new Student("Thomas", "Peterson", 30);
        Student b = new Student("Thomas", "Blau", 45);
        Student c = new Student("Henry", "Smith", 23);
        Student d = new Student("Mike", "Doe", 25);
        Student e = new Student("Mary", "Williams", 58);

        List<Student> applicants = Arrays.asList(a, b, c, d, e);

        // scenario: get the average age of students with firstname 'Thomas'

        // first solution: prior to Java 8  (imperative style: we are commanding HOW the code should do at each stage)
        int avg = 0;
        int count = 0;
        int sum = 0;
        for (Student s : applicants) {
            if (s.getFirstname().equals("Thomas")) {
                count++;
                sum += s.getAge();
            }
        }

        avg = sum / count;


        // second solution: post Java 8 - using Streams API (declarative style: we are asking code WHAT we want at each stage)
        Stream<Student> applicantsStream = applicants.stream();

        Double average = applicantsStream
                .filter(student -> student.getFirstname().equals("Thomas"))  // Stream<Student>
                .map(student -> student.getAge())  // Stream<Integer>
                .collect(Collectors.averagingInt(age -> age.intValue()));  // Double

        System.out.println("calculated average using Streams API: " + average);

        applicants.stream()
                .sorted((s1, s2) -> s1.getAge() - s2.getAge())  // Stream<Student>
                .forEach(s -> System.out.println(s.getLastname()));


        // ==================== another example ==============================
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        // Scenario: Find all bingo numbers starting with letter 'g' or 'G'

        // 1. imperative(pre-Java 8)
        List<String> gNumbers = new ArrayList<>();
        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });

        System.out.println(gNumbers);

        System.out.println("================================");
        // 2. declarative (post-Java 8)
        someBingoNumbers.stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(s -> System.out.println(s));
        // TODO: Homework: Fix above code to print out 'g64' as it is and not 'G64'

        /**
         * @see Exercise
         * */

    }
}
