package org.workspace.exercise.string;

import java.util.Scanner;

public class CharacterCounterStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một chuỗi: ");
        String input = scanner.nextLine();

        long totalChars = input.length();
        long uppercaseCount = input.chars().filter(Character::isUpperCase).count();
        long lowercaseCount = input.chars().filter(Character::isLowerCase).count();
        long digitCount = input.chars().filter(Character::isDigit).count();
        long spaceCount = input.chars().filter(Character::isWhitespace).count();
        long specialCount = input.chars().filter(c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c)).count();


        System.out.println("\n--- RESULT ---");
        System.out.println("Số chữ HOA: " + uppercaseCount);
        System.out.println("Số chữ thường: " + lowercaseCount);
        System.out.println("Số chữ số: " + digitCount);
        System.out.println("Số khoảng trắng: " + spaceCount);
        System.out.println("Số ký tự đặc biệt: " + specialCount);

        scanner.close();
    }
}
