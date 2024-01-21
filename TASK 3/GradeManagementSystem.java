// Task 3
// Grade Management System
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GradeManagementSystem {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("1. Add Student\n2. Update Student\n3. Delete Student\n4. View Student Info\n5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        updateStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        viewStudentInfo();
                        break;
                    case 5:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void addStudent() {
        try {
            System.out.print("Enter student name: ");
            String name = scanner.next();
            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();

            Student student = new Student(name, rollNumber);
            students.add(student);

            System.out.println("Student added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void updateStudent() {
        try {
            System.out.print("Enter roll number of the student to update: ");
            int rollNumber = scanner.nextInt();

            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    System.out.println("1. Add Subject Mark\n2. Update Subject Mark\n3. Delete Subject\n4. Back");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1 ->
                            addSubjectMark(student);
                        case 2 ->
                            updateSubjectMark(student);
                        case 3 ->
                            deleteSubject(student);
                        case 4 -> {
                            return;
                        }
                        default -> {
                            System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    }
                }
            }

            System.out.println("Student not found with the given roll number.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void addSubjectMark(Student student) {
        try {
            System.out.print("Enter subject name: ");
            String subject = scanner.next();
            System.out.print("Enter subject mark: ");
            int mark = scanner.nextInt();

            student.addSubjectMark(subject, mark);

            System.out.println("Subject mark added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void updateSubjectMark(Student student) {
        try {
            System.out.print("Enter subject name to update: ");
            String subject = scanner.next();

            student.updateSubjectMark(subject, scanner.nextInt());

            System.out.println("Subject mark updated successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void deleteSubject(Student student) {
        try {
            System.out.print("Enter subject name to delete: ");
            String subject = scanner.next();

            student.deleteSubject(subject);

            System.out.println("Subject deleted successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        try {
            System.out.print("Enter roll number of the student to delete: ");
            int rollNumber = scanner.nextInt();

            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    students.remove(student);
                    System.out.println("Student deleted successfully.");
                    return;
                }
            }

            System.out.println("Student not found with the given roll number.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void viewStudentInfo() {
        try {
            System.out.print("Enter roll number of the student to view info: ");
            int rollNumber = scanner.nextInt();

            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    System.out.println("Student Name: " + student.getName());
                    System.out.println("Roll Number: " + student.getRollNumber());
                    System.out.println("Subject Marks: " + student.getSubjectMarks());
                    System.out.println("Overall Percentage: " + student.calculatePercentage() + "%");
                    System.out.println("Grade: " + student.calculateGrade());
                    return;
                }
            }

            System.out.println("Student not found with the given roll number.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

class Student {

    private final String name;
    private final int rollNumber;
    private final Map<String, Integer> subjectMarks;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public void addSubjectMark(String subject, int mark) {
        subjectMarks.put(subject, mark);
    }

    public void updateSubjectMark(String subject, int mark) {
        if (subjectMarks.containsKey(subject)) {
            subjectMarks.put(subject, mark);
        } else {
            System.out.println("Subject not found for the student.");
        }
    }

    public void deleteSubject(String subject) {
        if (subjectMarks.containsKey(subject)) {
            subjectMarks.remove(subject);
        } else {
            System.out.println("Subject not found for the student.");
        }
    }

    public double calculatePercentage() {
        if (subjectMarks.isEmpty()) {
            return 0.0;
        }

        int totalMarks = subjectMarks.values().stream().mapToInt(Integer::intValue).sum();
        return (double) totalMarks / subjectMarks.size();
    }

    public String calculateGrade() {
        double percentage = calculatePercentage();

        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 75) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 45) {
            return "D";
        } else if (percentage >= 36) {
            return "E";
        } else {
            return "F";
        }
    }
}