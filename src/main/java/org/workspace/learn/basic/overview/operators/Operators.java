package org.workspace.learn.basic.overview.operators;

public class Operators {
    public static void main(String[] args) {
        /*
            + (plus or addition; also used for string concatenation)
            – (minus or subtraction)
            * (multiplication)
            / (division)
            % (modulus or remainder)
        */
        int firstNumbers = 5, secondNumbers = 3;
        System.out.println("firstNumbers = " + firstNumbers);
        System.out.println("secondNumbers = " + secondNumbers);
        System.out.println(firstNumbers + " + " + secondNumbers + " = " + (firstNumbers + secondNumbers));
        System.out.println(firstNumbers + " - " + secondNumbers + " = " + (firstNumbers - secondNumbers));
        System.out.println(firstNumbers + " * " + secondNumbers + " = " + (firstNumbers * secondNumbers));
        System.out.println(firstNumbers + " / " + secondNumbers + " = " + (firstNumbers / secondNumbers));
        System.out.println(firstNumbers + " % " + secondNumbers + " = " + (firstNumbers % secondNumbers));
    }
}
