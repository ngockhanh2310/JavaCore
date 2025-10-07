package org.workspace.learn.basic.arrays.one_dimensional;

public class Example {
    public static void main(String[] args) {
        // Cách 1: Khai báo và cấp phát kích thước
        int[] numbers = new int[5];

        // Cách 2: Khai báo và khởi tạo giá trị
        int[] nums = {1, 2, 3, 4, 5};

        // Cách 3: Khai báo riêng và cấp phát sau
        int[] arr;
        arr = new int[3];

        int[] original = {10, 20, 30};
        int[] copied = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copied[i] = original[i];
        }

    }
}
