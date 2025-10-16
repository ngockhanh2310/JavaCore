package org.workspace.learn.basic.exception_handling;

public class Example {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b; // May cause ArithmeticException - Có thể gây lỗi chia cho 0
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero! - Lỗi: Chia cho 0!");
        } finally {
            System.out.println("End of program - Kết thúc chương trình");
        }
    }
}
