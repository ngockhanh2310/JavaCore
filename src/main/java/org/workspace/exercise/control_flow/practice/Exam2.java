package org.workspace.exercise.control_flow.practice;

import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int month = 0, year = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter month (1-12): ");
                String monthInput = scanner.nextLine().trim();
                System.out.println("Enter year: ");
                String yearInput = scanner.nextLine().trim();
                if (checkInput(monthInput) && checkInput(yearInput)) {
                    year = Integer.parseInt(yearInput);
                    month = Integer.parseInt(monthInput);
                    if (month >= 1 && month <= 12) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid month! Please enter a month between 1 and 12.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter valid numbers for month and year.");
                }
            }
            int day = daysInMonth(month, year);
            System.out.println("Number of days in month " + month + " of year " + year + " is: " + day);

        }
    }

    private static int daysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                if (isLeapYear(year)) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            default -> -1;
        };
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private static boolean checkInput(String str) {
        String regex = "-?\\d+";
        if (!str.matches(regex)) {
            return false;
        }

        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
