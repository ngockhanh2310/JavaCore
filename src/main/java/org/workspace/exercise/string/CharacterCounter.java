package org.workspace.exercise.string;

import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String str = scanner.nextLine();

            int totalChars = str.length(); // total number of characters
            int uppercaseCount = 0; // number of uppercase letters
            int lowercaseCount = 0; // number of lowercase letters
            int digitCount = 0; // number of digits
            int spaceCount = 0; // number of spaces
            int specialCount = 0; // number of special characters

            for (int i = 0; i < totalChars; i++) {
                char c = str.charAt(i);
                if (Character.isUpperCase(c)) {
                    uppercaseCount++;
                }
                if (Character.isLowerCase(c)) {
                    lowercaseCount++;
                }
                if (Character.isDigit(c)) {
                    digitCount++;
                }
                if (Character.isWhitespace(c)) {
                    spaceCount++;
                } else {
                    specialCount++;
                }
            }
            System.out.println("Tổng số ký tự: " + totalChars);
            System.out.println("Số chữ HOA: " + uppercaseCount);
            System.out.println("Số chữ thường: " + lowercaseCount);
            System.out.println("Số chữ số: " + digitCount);
            System.out.println("Số khoảng trắng: " + spaceCount);
            System.out.println("Số ký tự đặc biệt: " + specialCount);
        }
    }
}
