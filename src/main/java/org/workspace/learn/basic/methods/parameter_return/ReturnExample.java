package org.workspace.learn.basic.methods.parameter_return;

public class ReturnExample {
    // method max - phương thức max
    public static int max(int a, int b) {
        // Compare a and b - So sánh a và b
        if (a > b) {
            return a; // Return a if it's larger - Trả về a nếu nó lớn hơn
        } else {
            return b; // Otherwise return b - Ngược lại trả về b
        }
    }

    public static void main(String[] args) {
        int bigger = max(10, 25); // Call method max - Gọi phương thức max
        System.out.println("Max = " + bigger); // Print result - In kết quả
    }
}
