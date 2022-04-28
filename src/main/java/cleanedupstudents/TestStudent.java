package cleanedupstudents;

import students.Student;
import superiterable.SuperIterable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStudent {
    public static void main(String[] args) {

        List<Student> school = List.of(
                students.Student.of("Fred", 3.5, "Math", "Physics"),
                students.Student.of("Jim", 2.9, "Journalism"),
                Student.of("Sheila", 3.9, "Math", "Physics","Astrophysics", "Quantum Mechanics"),
                Student.of("Sam", 3.8, "Math", "Physics","Astrophysics", "Quantum Mechanics")
        );
        System.out.println("*******************************************************");
        school.stream().filter( student -> student.getGpa() < 3.6).map(s -> "Dear "+s.getName()+" your grade of "+s.getGpa()+" is terrible ").forEach(System.out::println);

        System.out.println("************************** Entusiatic Student*****************************");
        school.stream().filter( student -> student.getCourses().size() > 1).flatMap(s -> s.getCourses().stream()).forEach(System.out::println);

        // Print courses without duplicates
        System.out.println("**************************Non Duplicate Course *****************************");
        school.stream().filter( student -> student.getGpa() > 3.6).flatMap(s -> s.getCourses().stream()).distinct().forEach(System.out::println);

        System.out.println("******************* Alphabetical Order Course ************************************");
        school.stream().filter( student -> student.getGpa() > 3.6).flatMap(s -> s.getCourses().stream()).distinct()
                .sorted() // MEMORY Issue can occur
                .forEach(System.out::println);

        school.stream().filter(student -> student.getGpa() > 3.6).flatMap(s -> s.getCourses().stream()).distinct().sorted().forEach(x -> System.out.println("Alphabetical Order Course "+x));

        System.out.println("********************* Name Course Pair **********************************");
        school.stream().flatMap((Student s) -> {
            return s.getCourses().stream()
                    .map(c -> "Student "+s.getName()+" takes course "+c);
        }).forEach(System.out::println);

        System.out.println("********************* Name Course Pair More  Clean up **********************************");
        school.stream().flatMap(s -> s.getCourses().stream()
                    .map(c -> "Student "+s.getName()+" takes course "+c)).forEach(System.out::println);

        System.out.println("********************* Name Course Pair More  Clean up using Function **********************************");

        Function<Student, Stream<String>> studentCoursePairs = s -> s.getCourses().stream()
                .map(c -> "Student "+s.getName()+" takes course "+c);

        school.stream().flatMap(studentCoursePairs).forEach(System.out::println);

    }
}
