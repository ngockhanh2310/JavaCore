package org.workspace.exercise.control_flow.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long number = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter number: ");
                String input = scanner.nextLine().trim();

                if (checkInput(input)) {
                    number = Long.parseLong(input);
                    validInput = true;
                } else {
                    System.out.println("Invalid input! Please enter a valid number!");
                }
            }
            if (checkNumber(number)) {
                System.out.println("The number entered is even");
            } else {
                System.out.println("The number entered is odd");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean checkNumber(long number) {
        return number % 2 == 0;
    }

    private static boolean checkInput(String str) {
        String regex = "-?\\d+";
        if (!str.matches(regex)) {
            return false;
        }

        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
