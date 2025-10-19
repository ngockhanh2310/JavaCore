package org.workspace.exercise.control_flow.practice;

import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter a positive integer: ");
                String input = scanner.nextLine().trim();

                if (checkInput(input)) {
                    number = Integer.parseInt(input);
                    if (number > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Please enter a positive integer greater than zero.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid positive integer.");
                }
            }

            int sumFor = sumOfNumbersFor(number);
            int sumWhile = sumOfNumbersWhile(number);
            int sumDoWhile = sumOfNumbersDoWhile(number);
            int sum = sumOfNumbers(number);

            System.out.println("Sum using for loop: " + sumFor);
            System.out.println("Sum using while loop: " + sumWhile);
            System.out.println("Sum using do-while loop: " + sumDoWhile);
            System.out.println("Sum using recursion: " + sum);

        }
    }

    private static int sumOfNumbersFor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    private static int sumOfNumbersWhile(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }

    private static int sumOfNumbersDoWhile(int n) {
        int sum = 0;
        int i = 1;
        do {
            sum += i;
            i++;
        } while (i <= n);
        return sum;
    }

    private static int sumOfNumbers(int n) {
        if (n > 0)
            return n + sumOfNumbers(n - 1);
        return 0;
    }

    private static boolean checkInput(String str) {
        String regex = "-?\\d+";
        if (!str.matches(regex)) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
