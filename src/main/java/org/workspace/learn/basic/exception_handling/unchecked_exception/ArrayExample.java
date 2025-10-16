package org.workspace.learn.basic.exception_handling.unchecked_exception;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        try {
            System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index không hợp lệ: " + e.getMessage());
        }
    }
}
