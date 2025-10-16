package org.workspace.learn.basic.exception_handling;

public class MultiCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // Array index out of bounds - Truy cập vượt chỉ số
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error - Lỗi chỉ số mảng");
        } catch (ArithmeticException e) {
            System.out.println("Math error - Lỗi toán học");
        } catch (Exception e) {
            System.out.println("General error - Lỗi chung: " + e.getMessage());
        }
    }
}
