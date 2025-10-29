package org.workspace.exercise.oop.database;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║   SCHOOL MANAGEMENT SYSTEM WITH DATABASE ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // Test kết nối database
        if (!DatabaseConnection.testConnection()) {
            System.out.println("\n⚠ Cannot connect to database. Please check your configuration.");
            System.out.println("   - Database name: lesson");
            System.out.println("   - Table name: student");
            System.out.println("   - Check DatabaseConnection.java for URL, USER, PASS");
            return;
        }

        int choice;
        do {
            displayMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudentById();
                    break;
                case 6:
                    searchStudentByName();
                    break;
                case 7:
                    checkStudentAge20();
                    break;
                case 8:
                    countStudentsAge23Vietnam();
                    break;
                case 0:
                    System.out.println("\n✓ Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("\n⚠ Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║              MAIN MENU                   ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1. Add new student                      ║");
        System.out.println("║  2. Display all students                 ║");
        System.out.println("║  3. Update student by ID                 ║");
        System.out.println("║  4. Delete student by ID                 ║");
        System.out.println("║  5. Search student by ID                 ║");
        System.out.println("║  6. Search student by name               ║");
        System.out.println("║  7. Check for student aged 20            ║");
        System.out.println("║  8. Count students aged 23 from Vietnam  ║");
        System.out.println("║  0. Exit                                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    private static void addStudent() {
        System.out.println("\n--- ADD NEW STUDENT ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        int age = getIntInput("Enter age: ");
        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        System.out.print("Enter class: ");
        String className = scanner.nextLine();

        Student student = new Student(name, age, country, className);

        if (studentDAO.addStudent(student)) {
            System.out.println("✓ Student added successfully!");
        } else {
            System.out.println("✗ Failed to add student.");
        }
    }

    private static void displayAllStudents() {
        System.out.println("\n--- ALL STUDENTS ---");
        List<Student> students = studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("⚠ No students found in database.");
        } else {
            System.out.println("Total students: " + students.size());
            for (Student student : students) {
                student.display();
            }
        }
    }

    private static void updateStudent() {
        System.out.println("\n--- UPDATE STUDENT ---");
        int id = getIntInput("Enter student ID to update: ");

        Student existingStudent = studentDAO.findStudentById(id);
        if (existingStudent == null) {
            System.out.println("⚠ Student with ID " + id + " not found.");
            return;
        }

        System.out.println("\nCurrent information:");
        existingStudent.display();

        System.out.println("\nEnter new information:");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        int age = getIntInput("Enter age: ");
        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        System.out.print("Enter class: ");
        String className = scanner.nextLine();

        Student updatedStudent = new Student(name, age, country, className);

        if (studentDAO.updateStudent(id, updatedStudent)) {
            System.out.println("✓ Student updated successfully!");
        } else {
            System.out.println("✗ Failed to update student.");
        }
    }

    private static void deleteStudent() {
        System.out.println("\n--- DELETE STUDENT ---");
        int id = getIntInput("Enter student ID to delete: ");

        Student student = studentDAO.findStudentById(id);
        if (student == null) {
            System.out.println("⚠ Student with ID " + id + " not found.");
            return;
        }

        System.out.println("\nStudent to be deleted:");
        student.display();

        System.out.print("Are you sure you want to delete this student? (y/n): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            if (studentDAO.deleteStudent(id)) {
                System.out.println("✓ Student deleted successfully!");
            } else {
                System.out.println("✗ Failed to delete student.");
            }
        } else {
            System.out.println("⚠ Deletion cancelled.");
        }
    }

    private static void searchStudentById() {
        System.out.println("\n--- SEARCH STUDENT BY ID ---");
        int id = getIntInput("Enter student ID: ");

        Student student = studentDAO.findStudentById(id);
        if (student != null) {
            System.out.println("\n✓ Student found:");
            student.display();
        } else {
            System.out.println("⚠ Student with ID " + id + " not found.");
        }
    }

    private static void searchStudentByName() {
        System.out.println("\n--- SEARCH STUDENT BY NAME ---");
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<Student> students = studentDAO.searchStudentByName(name);

        if (students.isEmpty()) {
            System.out.println("⚠ No students found with name containing: " + name);
        } else {
            System.out.println("\n✓ Found " + students.size() + " student(s):");
            for (Student student : students) {
                student.display();
            }
        }
    }

    private static void checkStudentAge20() {
        System.out.println("\n--- CHECK STUDENT AGED 20 ---");
        boolean hasAge20 = studentDAO.hasStudentWithAge(20);

        if (hasAge20) {
            System.out.println("✓ There is at least one student aged 20.");
        } else {
            System.out.println("⚠ There are no students aged 20.");
        }
    }

    private static void countStudentsAge23Vietnam() {
        System.out.println("\n--- COUNT STUDENTS AGED 23 FROM VIETNAM ---");
        int count = studentDAO.countStudentsByAgeAndCountry(23, "Vietnam");
        System.out.println("✓ Number of students aged 23 from Vietnam: " + count);
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Invalid input. Please enter a valid number.");
            }
        }
    }
}
