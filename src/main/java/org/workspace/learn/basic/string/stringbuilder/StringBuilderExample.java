package org.workspace.learn.basic.string.stringbuilder;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" Java"); // Add text - Hello Java
        sb.insert(6, "Beautiful "); // Insert text - Hello Beautiful Java
        sb.replace(0, 5, "Hi"); // Replace part - Hi Beautiful Java
        sb.delete(0, 3); // Delete text - Xóa chuỗi con - Beautiful Java
        sb.reverse(); // Reverse text - avaJ lufituaeB
        // Length & Capacity
        System.out.println(sb.length());        // (độ dài thực)
        System.out.println(sb.capacity());      //

        // charAt & substring
        System.out.println(sb.charAt(0));       // 'a'
        System.out.println(sb.substring(0, 5)); // "avaJ "

        // setCharAt
        sb.setCharAt(0, 'h');         // "h"

        System.out.println(sb.toString()); // Convert to string - hvaJ lufituaeB
    }
}
