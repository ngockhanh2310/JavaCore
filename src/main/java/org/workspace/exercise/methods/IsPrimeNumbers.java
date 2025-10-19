package org.workspace.exercise.methods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IsPrimeNumbers {
    public static void main(String[] args) {
        int number = input();
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
        System.out.println("Factorial of " + number + " is:  " + number + "! = " + factorial(number));
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                System.out.println("You entered: " + number);
                return number;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }

    private static int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
