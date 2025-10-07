package org.workspace.learn.basic.control_flow.decision_statements;

public class IfElseExample {
    public static void main(String[] args) {
        int number = 5;

        // check number is positive - kiểm tra số dương
        if (number > 0) {
            System.out.println(number + " is positive"); // số dương
        } else if (number < 0) {
            System.out.println(number + " is negative"); // số âm
        } else {
            System.out.println(number + " is zero");
        }

    }
}
