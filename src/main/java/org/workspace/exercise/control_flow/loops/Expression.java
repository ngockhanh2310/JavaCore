package org.workspace.exercise.control_flow.loops;

import java.util.Scanner;

// Java - Tính giá trị của biểu thức S = 1 + 1.2 + 1.2.3 + ... + 1.2.3.n (n > 0).
// Java - Tính giá trị của biểu thức U = 1/2 + 2/3 + 3/4 + ... + n/(n+1) (n > 0).
// Java - Tính giá trị của biểu thức R = 1 + 2^2 + 3^3 + ... + n^n (n > 0).
public class Expression {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number n: ");
            int n = scanner.nextInt();
            while (n <= 0) {
                System.out.println("Number must be greater than 0. Please try again");
                System.out.print("Enter number n: ");
                n = scanner.nextInt();
            }
            System.out.println("Number: " + n);

            // Calculate the value of the expression S
            int totalS = 0;
            for (int i = 1; i <= n; i++) {
                int sum = 1;
                for (int j = 1; j <= i; j++) {
                    sum *= j;
                }
                totalS += sum;
            }
            System.out.println("S = " + totalS);

            // Calculate the value of the expression U
            float totalU = 0;
            for (int i = 1; i <= n; i++) {
                totalU += (float) i / (i + 1.0);
            }
            System.out.println("U = " + totalU);

            // Calculate the value of the expression R
            int totalR = 0;
            for (int i = 1; i <= n; i++) {
                int sum = 1;
                for (int j = 1; j <= i; j++) {
                    sum *= i;
                }
                totalR += sum;
            }
            System.out.println("R = " + totalR);
        }
    }
}
