package superiterable;

import students.Student;

import java.util.ArrayList;
import java.util.List;

public class UseStudentIterable {
    public static void main(String[] args) {
        Student student = Student.of("John",1.7,"Course");
        Student student1 = Student.of("Alice",2.2,"Course");
        Student student2 = Student.of("Maverick",2.5,"Course");
        Student student3 = Student.of("Susan",2.7,"Course");

        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        SuperIterable<Student> sis =
                new SuperIterable<>(list);
        sis.map(s -> " List "+s.getName());
        sis.forEach(s -> System.out.println(s.getName()));

        System.out.println("*******************************************************");

        SuperIterable<Student> sis1 =
                new SuperIterable<>(list);
        sis1.filter(s -> s.getGpa()> 2.3)
        .forEach(s -> System.out.println("Smart Student " + s.getName()));

        System.out.println("*******************************************************");

        SuperIterable<Student> sis2 =
                new SuperIterable<>(list);
        sis2.filter(s -> s.getGpa() < 2.3)
                .forEach(s -> System.out.println(" Dear " + s.getName()+" your grade of "+s.getGpa()+" isn't good enough"));

        System.out.println("*******************************************************");

        SuperIterable<Student> sis3 =
                new SuperIterable<>(list);
        sis3.filter(s -> s.getGpa() < 1.8)
                .forEach(s -> System.out.println(" Your grade is too  low  " + s.getName()+" your grade of "+s.getGpa()));

    }
}
