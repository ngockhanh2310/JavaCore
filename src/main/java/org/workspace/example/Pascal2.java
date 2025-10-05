package org.workspace.example;

import java.util.Scanner;

public class Pascal2 {
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
            for (int i = 0; i < number; i++) {
                System.out.print(i + 1);
            }
            for (int i = number - 2; i >= 0; i--) {
                System.out.print(i + 1);
            }
        }
    }
}
