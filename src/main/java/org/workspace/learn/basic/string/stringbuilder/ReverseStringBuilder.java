package org.workspace.learn.basic.string.stringbuilder;

public class ReverseStringBuilder {
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Khanh"));
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append("Khanh").append("\n");
        sb.append("Age: ").append(25).append("\n");
        sb.append("Country: ").append("Vietnam");

        System.out.println(sb);
    }
}
