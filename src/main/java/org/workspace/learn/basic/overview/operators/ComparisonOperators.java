package org.workspace.learn.basic.overview.operators;

public class ComparisonOperators {
    public static void main(String[] args) {
        /*
            < (less than)
            <= (less than or equal to)
            > (greater than)
            >= (greater than or equal to)
            == (equal to)
            != (NOT equal to)
         */
        int age = 15;
        boolean checkAge;
        if (age < 18) {
            checkAge = false;
        } else {
            checkAge = true;
        }
        if (!checkAge) {
            System.out.println("Over 18 years old required");
        } else {
            System.out.println("Be 18 years old");
        }

    }
}
