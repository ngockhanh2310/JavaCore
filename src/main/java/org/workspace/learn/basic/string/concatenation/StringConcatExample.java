package org.workspace.learn.basic.string.concatenation;

public class StringConcatExample {
    public static void main(String[] args) {
        String first = "Hello";
        String last = "Khanh";

        // Cách 1: Dùng toán tử + - Using +
        String fullName1 = first + " " + last;

        // Cách 2: Dùng concat() - Using concat()
        String fullName2 = first.concat(" ").concat(last);

        // Cách 3: Dùng String.format() - Using String.format()
        String fullName3 = String.format("%s %s", first, last);

        System.out.println(fullName1); // Hello Khanh
        System.out.println(fullName2); // Hello Khanh
        System.out.println(fullName3); // Hello Khanh
    }
}
