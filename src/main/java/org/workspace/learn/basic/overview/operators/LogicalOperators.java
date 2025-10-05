package org.workspace.learn.basic.overview.operators;

public class LogicalOperators {
    public static void main(String[] args) {
        /*
            && (AND)
            || (OR)
            ! (NOT)
         */
        int number = 6;

        if (number % 2 == 0 && number % 3 == 0) {
            System.out.println(number + " is divisible by 2 AND 3");
        }
        if (!(number == 5)) {
            System.out.println(number + " is not equal to 5");
        }
        if (number >= 0 || number % 2 == 0) {
            System.out.println(number + " is either greater than or equal to 0 OR divisible by 2");
        }
    }
}
