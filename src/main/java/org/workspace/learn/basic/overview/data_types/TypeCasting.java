package org.workspace.learn.basic.overview.data_types;

public class TypeCasting {
    public static void main(String[] args) {
        /*
         * Ép kiểu rộng
         */
        int i = 100;
        long l = i;     // chuyển từ kiểu dữ liệu integer lên kiểu long
        float f = l;    // chuyển từ kiểu dữ liệu long lên kiểu float
        System.out.println("Giá trị biến i = " + i);
        System.out.println("Giá trị biến l = " + l);
        System.out.println("Giá trị biến f = " + f);
        System.out.println();
        /*
         * Ép kiểu hẹp
         */
        double d = 100.04;
        long m = (long) d;    // chuyển từ kiểu dữ liệu double về kiểu long
        int n = (int) l;      // chuyển từ kiểu dữ liệu long về kiểu int
        System.out.println("Giá trị biến d = " + d);
        System.out.println("Giá trị biến m = " + m);
        System.out.println("Giá trị kiểu n = " + n);
    }
}
