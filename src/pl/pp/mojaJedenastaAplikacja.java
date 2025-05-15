package pl.pp; // Your package

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class mojaJedenastaAplikacja {
    public static void main(String[] args) {
        System.out.println("--- Student Data ---");

        List<Student> students = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Pawel", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        // Find student with the highest average grade
        if (students != null && !students.isEmpty()) {
            try {
                Student topStudent = students.stream()
                        .max(Comparator.comparingDouble(Student::calculateAverageGrade))
                        .orElseThrow(() -> new NoSuchElementException("No student found or list is empty."));

                System.out.printf("Student with the highest average: %s %s (%s) - Average: %.2f%n",
                        topStudent.getFirstName(),
                        topStudent.getLastName(),
                        topStudent.getIndexNumber(),
                        topStudent.calculateAverageGrade());
            } catch (NoSuchElementException e) {
                System.out.println("Error: Could not find the student with the highest average. " + e.getMessage());
            }
        } else {
            System.out.println("Student list is null or empty.");
        }

        // Sort students by last name and display
        System.out.println("\nStudents sorted by last name:");
        if (students != null && !students.isEmpty()) {
            List<Student> sortedStudents = students.stream()
                    .sorted(Comparator.comparing(Student::getLastName) // Sort by last name
                            .thenComparing(Student::getFirstName)) // Then by first name for tie-breaking
                    .collect(Collectors.toList());

            sortedStudents.forEach(student ->
                    System.out.printf("%s %s (%s) - Average: %.2f%n",
                            student.getFirstName(),
                            student.getLastName(),
                            student.getIndexNumber(),
                            student.calculateAverageGrade())
            );
        } else {
            System.out.println("Student list is null or empty, cannot sort.");
        }

        System.out.println("\n--- End of Student Data  ---");
    }
}