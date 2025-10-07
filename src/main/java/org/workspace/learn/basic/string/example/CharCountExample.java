package org.workspace.learn.basic.string.example;

public class CharCountExample {
    public static void main(String[] args) {
        String text = "banana";
        char target = 'a';
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                count++;
            }
        }

        System.out.println("Character '" + target + "' appears " + count + " times.");
        // English - Vietnamese: Ký tự 'a' xuất hiện count lần
    }
}
