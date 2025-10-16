package org.workspace.exercise.oop.lesson1;

import java.util.Scanner;

public class Info extends Student {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n;
            System.out.print("Enter the number of students: ");
            n = scanner.nextInt();
            scanner.nextLine();

            Student[] students = new Student[n];

            for (int i = 0; i < n; i++) {
                Student student = new Student();
                System.out.println("Enter Information Student " + (i + 1) + ": ");
                student.getInfo(scanner);
                students[i] = student;
            }

            System.out.println();
            System.out.println("Information All Students: ");
            for (int i = 0; i < n; i++) {
                System.out.println("Information Student " + (i + 1) + ": ");
                students[i].showInfo();
            }
            /*for (Student student : students) {
                student.showInfo();
            }*/
        }
    }
}
