package org.workspace.learn.basic.string.example;

public class PalindromeExample {
    public static void main(String[] args) {
        String word = "level";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println("Palindrome - Chuỗi đối xứng");
        } else {
            System.out.println("Not palindrome - Không đối xứng");
        }
    }
}
