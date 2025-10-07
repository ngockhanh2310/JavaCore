package org.workspace.learn.basic.control_flow.decision_statements;

public class TernaryOperator {
    public static void main(String[] args) {
        final int number = 5;
        String result = (number > 0) ? number + " is Positive" : number + " is Negative";
        System.out.println(result);
    }
}
