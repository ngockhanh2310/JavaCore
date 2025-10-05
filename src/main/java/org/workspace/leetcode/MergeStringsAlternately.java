package org.workspace.leetcode;

import java.util.Scanner;

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        // create a new string result
        String result = "";
        byte i = 0; // -2^7 -> 2^7 - 1
        while (i < word1.length() || i < word2.length()) { // check i < word1.length() || i < word2.length()
            if (i < word1.length())
                result += word1.charAt(i);
            if (i < word2.length())
                result += word2.charAt(i);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.print("Enter word1:");
            String word1 = scanner.nextLine();
            System.out.print("Enter word2:");
            String word2 = scanner.nextLine();

            System.out.println("New word result: " + mergeAlternately(word1, word2));
        }
    }
}
