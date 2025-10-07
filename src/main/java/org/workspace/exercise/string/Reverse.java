package org.workspace.exercise.string;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String:");
        String str = scanner.nextLine();
        String reverse = new StringBuilder(str).reverse().toString();
        System.out.println("String:" + str);
        System.out.println("Reverse:" + reverse);
        String s = "I";
        String s1 = "Love";
        String s2 = "You";
        String result = new StringBuilder(s).append(" ").append(s1).append(" ").append(s2).toString();
        System.out.println(result);
        String[] cut = str.trim().split(" ");
        for (int i = 0; i < cut.length; i++) {
            System.out.println(cut[i]);
        }
    }
}
