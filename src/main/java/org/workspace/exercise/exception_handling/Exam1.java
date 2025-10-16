package org.workspace.exercise.exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        long a, b;
        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        while (!check) {
            try {
                System.out.print("Enter a: ");
                a = scanner.nextLong();
                System.out.print("Enter b: ");
                b = scanner.nextLong();
                long result = a / b;
                System.out.println(a + " / " + b + " = " + result);
                check = true;
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero!");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input!");
                scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
