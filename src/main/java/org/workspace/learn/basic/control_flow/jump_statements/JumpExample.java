package org.workspace.learn.basic.control_flow.jump_statements;

public class JumpExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {

            if (i == 5)
                continue; // Skip iteration when i = 5
            if (i == 8)
                break; // Stop the loop when i = 8

            System.out.println("i = " + i);
        }
        // continue : skips the current iteration - bỏ qua vòng lặp hiện tại
        // break : exits the loop completely - thoát khỏi vòng lặp hoàn toàn
    }
}
