package org.workspace.learn.basic.arrays.one_dimensional;

public class ArraysJava {
    public static void main(String[] args) {
        // 1. Khai báo và khởi tạo mảng
        int[] numbers = {10, 20, 30, 40, 50};

        // 2. Truy cập phần tử
        System.out.println("Phần tử đầu tiên: " + numbers[0]);
        System.out.println("Phần tử cuối cùng: " + numbers[numbers.length - 1]);

        // 3. Duyệt mảng bằng for
        System.out.println("\nDuyệt mảng bằng for:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // 4. Duyệt mảng bằng for-each
        System.out.println("\nDuyệt mảng bằng for-each:");
        for (int num : numbers) {
            System.out.println(num);
        }

        // 5. Tính tổng các phần tử
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("\nTổng các phần tử = " + sum);
        // Exception: java.lang.ArrayIndexOutOfBoundsException
    }
}
