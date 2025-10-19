package org.workspace.exercise.string;

import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        String yourName = input();
        System.out.println("Your name : " + yourName);
        System.out.println("Uppercase: " + uppercase(yourName));
        System.out.println("Lowercase: " + lowercase(yourName));
        System.out.println("Capitalize Words: " + capitalizeWords(yourName));
        System.out.println("Capitalize Words 2: " + capitalizeWords2(yourName));
        System.out.println("Reversed String: " + reverseString(uppercase(yourName)));
        System.out.println("Reversed String 2: " + reverseString2(lowercase(yourName)));
        System.out.println("Reversed String 3: " + reverseString3(capitalizeWords(yourName)));
    }

    private static String input() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a string:");
            String str = input.nextLine();
            if (str != null && !str.trim().isEmpty()) {
                return str;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    // convert to uppercase - Chuyển thành chữ hoa
    private static String uppercase(String str) {
        return str.toUpperCase();
    }

    // convert to lowercase - Chuyển thành chữ thường
    private static String lowercase(String str) {
        return str.toLowerCase();
    }

    // Capitalize the first letter of each word - Viết hoa chữ cái đầu của mỗi từ
    private static String capitalizeWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] text = str.split("\\s+"); // split by whitespace - tách theo khoảng trắng
        StringBuilder sb = new StringBuilder();
        for (String word : text) { // duyệt từng từ
            if (!word.isEmpty()) { // kiểm tra từ không rỗng
                sb.append(Character.toUpperCase(word.charAt(0))) // viết hoa chữ cái đầu
                        .append(word.substring(1).toLowerCase()) // chuyển phần còn lại thành chữ thường
                        .append(" ");// thêm khoảng trắng sau mỗi từ
            }
        }
        return sb.toString().trim();
    }

    // Capitalize the first letter of each word - Cách 2
    private static String capitalizeWords2(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] text = str.split("\\s+"); // split by whitespace - tách theo khoảng trắng
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length; i++) {
            if (text[i].length() > 0) { // !text[i].isEmpty()
                sb.append(Character.toUpperCase(text[i].charAt(0)));
            }
            if (text[i].length() > 1) {
                sb.append(text[i].substring(1).toLowerCase());
            }
            if (i < text.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    private static String reverseString2(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            // swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    private static String reverseString3(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] characters = str.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = characters.length - 1; i >= 0; i--) {
            reversed.append(characters[i]).append(" ");
        }
        return reversed.toString().trim();
    }
}
