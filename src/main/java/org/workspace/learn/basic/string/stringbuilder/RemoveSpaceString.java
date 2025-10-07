package org.workspace.learn.basic.string.stringbuilder;

public class RemoveSpaceString {
    public static String removeSpaces(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeSpaces("H e l l o"));
        StringBuilder sb = new StringBuilder("HelloWorld");
        // insert character
        sb.insert(5, " ");              // "Hello World"
        System.out.println(sb);
    }
}
