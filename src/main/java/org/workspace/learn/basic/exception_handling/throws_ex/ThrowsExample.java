package org.workspace.learn.basic.exception_handling.throws_ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsExample {
    static void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        System.out.println(br.readLine());
        br.close();
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("File not found - Không tìm thấy file");
        }
    }
}

