package org.workspace.example;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number;
            System.out.print("Enter Number:");
            number = scanner.nextInt();

            // check number is greater than 0
            while (number <= 0) {
                System.out.println("Number must be greater than 0");
                System.out.print("Re-enter Number:");
                number = scanner.nextInt();
            }
            for (int i = 1; i <= number; i++) {
                for (int j = 0; j < number - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }
                for (int j = i - 1; j > 0; j--) {
                    System.out.print(j);
                }
                System.out.println();
            }
        }
    }
}
