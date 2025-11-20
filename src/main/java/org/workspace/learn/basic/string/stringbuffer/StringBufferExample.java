package org.workspace.learn.basic.string.stringbuffer;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer buff = new StringBuffer("Hello");

        buff.append(" Java"); // Add text - Hello Java
        buff.insert(6, "Beautiful "); // Insert text - Hello Beautiful Java
        buff.replace(0, 5, "Hi"); // Replace part - Hi Beautiful Java
        buff.delete(0, 3); // Delete text - Xóa chuỗi con - Beautiful Java
        buff.reverse(); // Reverse text - avaJ lufituaeB
        // Length & Capacity
        System.out.println(buff.length());        // (độ dài thực)
        System.out.println(buff.capacity());      //

        // charAt & substring
        System.out.println(buff.charAt(0));       // 'a'
        System.out.println(buff.substring(0, 5)); // "avaJ "

        // setCharAt
        buff.setCharAt(0, 'h');         // "h"

        System.out.println(buff.toString()); // Convert to string - hvaJ lufituaeB
    }
}
