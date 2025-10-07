package org.workspace.learn.basic.methods.structure;

public class Varargs {
    public static void main(String[] args) {
        System.out.println(format("Hello", "World"));
        System.out.println(formatWithVarArgs("Hello", "World", "Java", "Spring"));
    }

    public static String formatWithVarArgs(String... values) {
        String result = "";
        for (String value : values) {
            result += value + " ";
        }
        return result;
    }

    public static String format(String val1, String val2) {
        return val1 + " " + val2;
    }

    public static int checkNumber(int... numbers) {
        return 0;
    }
}
