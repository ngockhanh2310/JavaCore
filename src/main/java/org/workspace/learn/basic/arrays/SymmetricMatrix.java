package org.workspace.learn.basic.arrays;

import java.util.Scanner;

public class SymmetricMatrix {
    public static void main(String[] args) {
        int n;  // bậc của ma trận
        int kt = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào số bậc của ma trận: ");
            n = scanner.nextInt();
        } while (n < 1);

        // ma trận A là ma trận vuông
        // có n dòng và n cột
        int[][] A = new int[n][n];

        System.out.println("Nhập các phần tử cho ma trận A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "," + j + "] = ");
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Ma trận A vừa nhập:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println("\n");
        }

        // kiểm tra các phần tử nằm dưới đường chéo chính
        // và phần tử đối xứng với nó qua đường chéo chính
        // có bằng nhau hay không
        // nếu bằng nhau thì ma trận đó là ma trận đối xứng
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][j] == A[j][i]) {
                    kt = 1;
                } else {
                    kt = 0;
                }
            }
        }

        if (kt == 1) {
            System.out.println("Ma trận vừa nhập là ma trận đối xứng");
        } else {
            System.out.println("Ma trận vừa nhập là ma trận không đối xứng");
        }
    }
}
