package org.workspace.learn.basic.exception_handling.checked_exception;

import java.io.FileReader;
import java.io.IOException;

public class CheckedExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("file.txt"); // Có thể ném IOException
            reader.read();
            reader.close();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        }
    }
}
