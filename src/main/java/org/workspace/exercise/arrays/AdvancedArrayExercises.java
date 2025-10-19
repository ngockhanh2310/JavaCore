package org.workspace.exercise.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class AdvancedArrayExercises {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // sum row, sum column
            matrix2DExample(scanner);

            // sort array descending
            sortDescendingExample(scanner);

            // compare two arrays
            compareArraysExample(scanner);

            // reverse array
            System.out.println("\n========== EXERCISE 4: REVERSE ARRAY MANUALLY ==========");
            reverseArrayExample(scanner);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // sum row, sum column
    private static void matrix2DExample(Scanner scanner) {
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        // check input
        if (rows <= 0 || cols <= 0) {
            System.out.println("Rows and columns must be positive!");
            return;
        }

        // initialize matrix
        int[][] matrix = new int[rows][cols];

        // input matrix
        inputMatrix(scanner, matrix, rows, cols);

        // print matrix
        System.out.println("\n--- Matrix ---");
        printMatrix(matrix, rows, cols);

        // Calculate the sum of each row
        System.out.println("\n--- Sum of Each Row ---");
        sumOfRows(matrix, rows, cols);

        // Calculate the sum of each column
        System.out.println("\n--- Sum of Each Column ---");
        sumOfColumns(matrix, rows, cols);

        // Calculate the total sum of the matrix
        int totalSum = sumOfMatrix(matrix, rows, cols);
        System.out.println("\n--- Total Sum of Matrix: " + totalSum + " ---");
    }

    // input matrix
    private static void inputMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        System.out.println("\nEnter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Print 2-dimensional array to screen as matrix
    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d ", matrix[i][j]); // Format để căn đều
            }
            System.out.println();
        }
    }

    // Calculate the sum of each row
    private static void sumOfRows(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;

            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }

            System.out.println("Row " + i + ": " + rowSum);
        }
    }

    // Calculate the sum of each column
    private static void sumOfColumns(int[][] matrix, int rows, int cols) {
        // Iterate through each column
        for (int j = 0; j < cols; j++) {
            int colSum = 0;

            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }

            System.out.println("Column " + j + ": " + colSum);
        }
    }

    // Calculate the total sum of the matrix
    private static int sumOfMatrix(int[][] matrix, int rows, int cols) {
        int totalSum = 0;

        // Iterate through all elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalSum += matrix[i][j];
            }
        }

        return totalSum;
    }

    // sort array
    private static void sortDescendingExample(Scanner scanner) {
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Size must be positive!");
            return;
        }

        int[] array = new int[size];

        // enter array
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = scanner.nextInt();
        }

        // print array
        System.out.println("\nOriginal array: " + Arrays.toString(array));

        // sort the array in descending order
        sortDescending(array);

        // print the sorted array
        System.out.println("Sorted (descending): " + Arrays.toString(array));
    }

    // Selection Sort
    private static void sortDescending(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    // compare arrays
    private static void compareArraysExample(Scanner scanner) {
        System.out.print("Enter size of first array: ");
        int size1 = scanner.nextInt();

        if (size1 <= 0) {
            System.out.println("Size must be positive!");
            return;
        }

        int[] array1 = new int[size1];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < size1; i++) {
            System.out.print("array1[" + i + "] = ");
            array1[i] = scanner.nextInt();
        }

        System.out.print("\nEnter size of second array: ");
        int size2 = scanner.nextInt();

        if (size2 <= 0) {
            System.out.println("Size must be positive!");
            return;
        }

        int[] array2 = new int[size2];

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < size2; i++) {
            System.out.print("array2[" + i + "] = ");
            array2[i] = scanner.nextInt();
        }

        System.out.println("\nArray 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));

        boolean areEqual = Arrays.equals(array1, array2);
        System.out.println("\nUsing Arrays.equals(): " + (areEqual ? "Equal" : "Not Equal"));

        boolean manualEqual = compareArraysManually(array1, array2);
        System.out.println("Using manual comparison: " + (manualEqual ? "Equal" : "Not Equal"));
    }


    private static boolean compareArraysManually(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    // reverse array
    private static void reverseArrayExample(Scanner scanner) {
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Size must be positive!");
            return;
        }

        int[] array = new int[size];

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal array: " + Arrays.toString(array));

        reverseArrayManually(array);

        System.out.println("Reversed array: " + Arrays.toString(array));
    }


    private static void reverseArrayManually(int[] array) {
        int n = array.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
    }

    // BONUS
    // find max matrix 2d
    private static int
    findMaxInMatrix(int[][] matrix, int rows, int cols) {
        int max = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    // find min matrix 2d
    private static int findMinInMatrix(int[][] matrix, int rows, int cols) {
        int min = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }

    // transpose matrix
    private static int[][] transposeMatrix(int[][] matrix, int rows, int cols) {
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
