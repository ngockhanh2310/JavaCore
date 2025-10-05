package org.workspace.learn.basic.overview.arrays;

public class ArraysJava {
    public static void main(String[] args) {
        // array declaration - khai báo mảng
        int[] numbers = new int[10];

        // array initialization - gán giá trị cho mảng
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        int thirdElement = numbers[2];
        System.out.println("The third element of the numbers array is: " + thirdElement);

        // array length - lấy độ dài của mảng
        int lengthOfNumbersArray = numbers.length;
        System.out.println("The length of the numbers array is: " + lengthOfNumbersArray);
    }
}
