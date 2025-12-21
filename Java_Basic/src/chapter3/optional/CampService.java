package chapter3.optional;

import java.util.Optional;

public class CampService {
    // - Var
    private static Student[] students = {
            new Student("Spartan"),
            new Student("Steve"),
            new Student("John") };

    // - Func
    public Optional<Student[]> getStudents() {
        return Optional.ofNullable(students);
    }
}
