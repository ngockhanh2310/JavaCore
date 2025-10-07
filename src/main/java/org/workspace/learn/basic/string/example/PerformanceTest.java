package org.workspace.learn.basic.string.example;

public class PerformanceTest {
    public static void main(String[] args) {
        int n = 100000;

        // String (RẤT CHẬM)
        long start1 = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a";
        }
        long end1 = System.currentTimeMillis();
        System.out.println("String: " + (end1 - start1) + "ms");

        // StringBuilder (NHANH)
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end2 - start2) + "ms");

        // StringBuffer (HƠI CHẬM HƠN StringBuilder)
        long start3 = System.currentTimeMillis();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buf.append("a");
        }
        long end3 = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (end3 - start3) + "ms");
    }
}
