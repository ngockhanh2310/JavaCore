package org.workspace.learn.basic.arrays;

import java.util.Arrays;

public class ArraysUtilDemo {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7};

        // Sắp xếp mảng
        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));

        // Tìm kiếm nhị phân
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("Index of 7: " + index);

        // Sao chép mảng
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied: " + Arrays.toString(copy));

        // So sánh hai mảng
        System.out.println("Equal? " + Arrays.equals(numbers, copy));
    }
}

