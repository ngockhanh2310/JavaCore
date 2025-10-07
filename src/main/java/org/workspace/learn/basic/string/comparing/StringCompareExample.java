package org.workspace.learn.basic.string.comparing;

public class StringCompareExample {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        // Compare using == - So sánh địa chỉ bộ nhớ (reference)
        System.out.println(s1 == s2); // true (same object in String Pool)
        System.out.println(s1 == s3); // false (different object)

        // Compare using equals() - So sánh nội dung (content)
        System.out.println(s1.equals(s3)); // true (same content)
    }
}
