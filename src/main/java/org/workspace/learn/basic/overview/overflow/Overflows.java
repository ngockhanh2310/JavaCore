package org.workspace.learn.basic.overview.overflow;

public class Overflows {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        int j = i + 1;
        // j will roll over to -2_147_483_648
        System.out.println(j);

        double d = Double.MAX_VALUE;
        double o = d + 1;
        // o will be Infinity
        System.out.println(o);
    }
}
