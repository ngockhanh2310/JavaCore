package org.workspace.learn.basic.string.example;

public class WordCountExample {
    public static void main(String[] args) {
        String sentence = "  Java  is   fun  and  powerful  ";
        System.out.println(sentence.length());

        // Cách 1: Xử lý chuỗi trước khi split
        String trimmed = sentence.trim();  // Xóa khoảng trắng đầu/cuối
        if (trimmed.isEmpty()) {
            System.out.println("Number of words: 0");
        } else {
            String[] words = trimmed.split("\\s+");  // \\s+ = 1 hoặc nhiều whitespace
            System.out.println("Number of words: " + words.length);
        }

        // Cách 2: Dùng Stream (Java 8+) - Tinh gọn hơn
        long count = sentence.trim().split("\\s+").length;
        System.out.println("Number of words: " + count);
    }
}
