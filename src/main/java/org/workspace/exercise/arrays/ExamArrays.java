package org.workspace.exercise.arrays;

import java.util.Scanner;

public class ExamArrays {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elements in the array: ");
            int size = scanner.nextInt();
            // Size > 0
            if (size <= 0) {
                System.out.println("Array size must be positive!");
                return;
            }
            int[] arr = new int[size + 10]; // Extra space for adding elements
            // Input array
            inputArray(scanner, arr, size);
            // Print array
            printArray(arr, size);
            // Calculate average value of array
            System.out.println("Average value of array: " + calculateAverage(arr, size));
            // Find max value of array
            System.out.println("Max value of array: " + findMax(arr, size));
            // Find min value of array
            System.out.println("Min value of array: " + findMin(arr, size));
            // Reverse array
            reverseArray(arr, size);
            System.out.println("Reversed array:");
            printArray(arr, size);
            // Sort array in ascending order
            sortArray(arr, size);
            System.out.println("Sorted array:");
            printArray(arr, size);
            // Add element to array
            System.out.print("Enter element to add to array: ");
            int element = scanner.nextInt();
            size = addElementToArray(arr, size, element);
            System.out.println("Array after adding element:");
            printArray(arr, size);
            // Add element to array at specific index
            System.out.print("Enter element to add to array: ");
            int element2 = scanner.nextInt();
            System.out.print("Enter index to add element: ");
            int index = scanner.nextInt();
            size = addElementToArrayAtIndex(arr, size, element2, index);
            System.out.println("Array after adding element at specific index:");
            printArray(arr, size);
            // Remove element from array at specific index
            System.out.print("Enter index to remove element: ");
            int index2 = scanner.nextInt();
            size = removeElementFromArrayAtIndex(arr, size, index2);
            System.out.println("Array after removing element at specific index:");
            printArray(arr, size);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Input array
    private static void inputArray(Scanner scanner, int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("Enter arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }
    }

    // Print array
    private static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(" arr[" + i + "] = " + arr[i]);
        }
        System.out.println();
    }

    // Calculate average value of array
    private static float calculateAverage(int[] arr, int size) {
        if (size == 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        return (float) sum / size;
    }

    // Find max value of array
    private static int findMax(int[] arr, int size) {
        if (size == 0) {
            throw new IllegalArgumentException("Array size is empty");
        }
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Find min value of array
    private static int findMin(int[] arr, int size) {
        if (size == 0) {
            throw new IllegalArgumentException("Array size is empty");
        }
        int min = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // Reverse array
    private static void reverseArray(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
    }

    // Sort array in ascending order
    private static void sortArray(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
    }

    // Add element to array
    private static int addElementToArray(int[] arr, int size, int element) {
        if (size >= arr.length) {
            System.out.println("Array is full, cannot add element");
            return size;
        }
        arr[size] = element;
        return size + 1;
    }

    // Add element to array at specific index
    private static int addElementToArrayAtIndex(int[] arr, int size, int element, int index) {
        if (size >= arr.length) {
            System.out.println("Array is full, cannot add element");
            return size;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return size;
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        return size + 1;
    }

    // Remove element from array at specific index
    private static int removeElementFromArrayAtIndex(int[] arr, int size, int index) {
        if (size == 0) {
            System.out.println("Array is empty, cannot remove element");
            return size;
        }
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return size;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return size - 1;
    }
}
