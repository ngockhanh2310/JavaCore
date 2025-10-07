package org.workspace.learn.basic.string.stringbuffer;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer buf = new StringBuffer("Hello");

        buf.append(" Java"); // Add text - Hello Java
        buf.insert(6, "Beautiful "); // Insert text - Hello Beautiful Java
        buf.replace(0, 5, "Hi"); // Replace part - Hi Beautiful Java
        buf.delete(0, 3); // Delete text - Xóa chuỗi con - Beautiful Java
        buf.reverse(); // Reverse text - avaJ lufituaeB
        // Length & Capacity
        System.out.println(buf.length());        // (độ dài thực)
        System.out.println(buf.capacity());      //

        // charAt & substring
        System.out.println(buf.charAt(0));       // 'a'
        System.out.println(buf.substring(0, 5)); // "avaJ "

        // setCharAt
        buf.setCharAt(0, 'h');         // "h"

        System.out.println(buf.toString()); // Convert to string - hvaJ lufituaeB
    }
}
