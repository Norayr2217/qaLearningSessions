package main.com.test;

import main.compare.Student;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ComparatorFlow {

    public static void main(String[] args) {
        Student firstStudent = new Student("Andrew", 20, 176);
        Student secondStudent = new Student("Benny", 21, 187);
        Student thirdStudent = new Student("Henry", 19, 167);

        Optional<Student> min = Stream.of(firstStudent, secondStudent, thirdStudent)
                .min(Comparator.comparing(student -> student.getName()));

        System.out.println(min.get());
    }
}
