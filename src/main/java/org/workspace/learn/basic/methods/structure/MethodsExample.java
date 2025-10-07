package org.workspace.learn.basic.methods.structure;

public class MethodsExample {
    // 1 Method không trả về (void method) - No return value
    public static void printHello() {
        System.out.println("Hello Java!"); // Print message
    }

    // 2 Method có trả về (return method) - Has return value
    public static int add(int a, int b) {
        return a + b; // Return sum
    }

    // 3 Method có tham số - Method with parameters
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!"); // Greet user
    }

    public static void main(String[] args) {
        printHello(); // Call printHello()

        int result = add(5, 10); // Call add method
        System.out.println("Sum = " + result); // Print result

        greet("Khanh"); // Pass argument
    }
}
