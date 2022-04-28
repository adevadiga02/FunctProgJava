package grouping.practice;

import students.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestGrouping {

    public static String asLetterGrade(Student s){
        double g = s.getGpa();
        if(g > 3.5) return "A";
        if(g > 2.9) return "B";
        if(g > 2.8) return "C";

        return "D";
    }

    public static void main(String[] args) {

        List<Student> school = List.of(
                students.Student.of("Fred", 2.9, "Math", "Physics"),
                students.Student.of("Jim", 2.9, "Journalism"),
                Student.of("Sheila", 3.9, "Math", "Physics","Astrophysics", "Quantum Mechanics"),
                Student.of("Sam", 3.8, "Math", "Physics","Astrophysics", "Quantum Mechanics")
        );

        school.stream()
                .collect(Collectors.groupingBy(TestGrouping::asLetterGrade))
                .entrySet().stream().forEach(System.out::println);

        System.out.println("*********************************************************");

        school.stream()
                .collect(Collectors.groupingBy(TestGrouping::asLetterGrade,Collectors.counting()))
                .entrySet().stream().forEach(System.out::println);

    }



}
