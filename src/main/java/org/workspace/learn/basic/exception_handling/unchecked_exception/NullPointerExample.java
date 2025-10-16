package org.workspace.learn.basic.exception_handling.unchecked_exception;

public class NullPointerExample {
    public static void main(String[] args) {
        String str = null;

        // Không bắt buộc try-catch, nhưng có thể gây crash
        try {
            int length = str.length(); // NullPointerException
            System.out.println("Chiều dài: " + length);
        } catch (NullPointerException e) {
            System.out.println("Lỗi: " + e.getMessage());
            // Xử lý an toàn
        }
    }
}
