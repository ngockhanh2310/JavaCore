package org.workspace.example;

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            short number;
            System.out.print("Number:");
            number = scanner.nextShort();
            while (number <= 0) {
                System.out.println("Number must be greater than 0");
                System.out.print("Number:");
                number = scanner.nextShort();
            }
            short[] arr = new short[number + (number - 1)];
            for (short i = 1; i <= number; i++) {
                if (i < number) {
                    arr[i - 1] = i;
                    arr[number + (number - 1) - i] = i;
                }
                if (i == number) {
                    arr[number - 1] = i;
                }
            }
            for (short result : arr) {
                System.out.print(result);
            }
        }
    }
}
