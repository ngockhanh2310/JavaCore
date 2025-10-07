package org.workspace.learn.basic.control_flow.loops;

public class DoWhileExample {
    public static void main(String[] args) {
        int i = 10;

        // Execute first, then check condition - Thực thi trước, sau đó kiểm tra điều kiện
        do {
            System.out.println("i = " + i); // Print i - In ra i
            i++;
        } while (i <= 5);
    }
}
