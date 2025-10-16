package org.workspace.learn.basic.exception_handling;

public class Exam {
    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Access denied!");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(16); // Will throw exception - Sẽ gây lỗi
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
