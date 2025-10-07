package org.workspace.learn.basic.methods.overloading;

public class OverloadingExample {
    // Add two integer
    public static int addNumber(int a, int b) {
        return a + b;
    }

    // Add three integer
    public static int addNumber(int a, int b, int c) {
        return a + b + c;
    }

    // Add Varargs
    public static int addNumber(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addNumber(1, 2));
        System.out.println(addNumber(3, 5, 4));
        System.out.println(addNumber(2, 4, 5, 6, 3, 2, 1));
    }
}
