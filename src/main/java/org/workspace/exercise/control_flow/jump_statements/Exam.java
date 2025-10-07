package org.workspace.exercise.control_flow.jump_statements;

public class Exam {
    public static void main(String... args) {
        for (int i = 1; i < 20; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.println("Number:" + i);
        }
    }
}
