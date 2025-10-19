package org.workspace.exercise.string;

public class Exam2 {
    public static void main(String[] args) {
        String test1 = "I love Java programming.";
        String test2 = "Python is great.";
        if (checkString(test1)) {
            System.out.println("Test1 contains 'Java'");
        } else {
            System.out.println("Test1 does not contain 'Java'");
        }
        if (checkString(test2)) {
            System.out.println("Test2 contains 'Java'");
        } else {
            System.out.println("Test2 does not contain 'Java'");
        }
    }

    private static boolean checkString(String str) {
        return str.contains("Java");
    }
}
