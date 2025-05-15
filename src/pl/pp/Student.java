package pl.pp; // Your package

import java.util.List;
import java.util.OptionalDouble;

public class Student {
    private String indexNumber;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String indexNumber, String firstName, String lastName, List<Integer> grades) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    // Getters
    public String getIndexNumber() { return indexNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public List<Integer> getGrades() { return grades; }

    public double calculateAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        // Using Java Streams
        OptionalDouble average = grades.stream()
                .mapToInt(Integer::intValue) // or i -> i
                .average();
        return average.orElse(0.0); // Return 0.0 if list was empty after filtering (not possible here) or if average is not present
    }

    @Override
    public String toString() { // For easier debugging or alternative printing
        return String.format("%s %s (%s) - Average: %.2f",
                firstName, lastName, indexNumber, calculateAverageGrade());
    }
}