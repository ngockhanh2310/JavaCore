package org.workspace.exercise.control_flow.switch_case;

import java.time.Month;
import java.time.Year;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month name (e.g., JANUARY):");
        String monthName = scanner.nextLine().toUpperCase();
        try {
            Month month = Month.valueOf(monthName);

            short result = switch (month) {
                case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
                case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
                case FEBRUARY -> {
                    short days;
                    // check year is leap or not
                    if (Year.now().isLeap()) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                    yield days;// yield to return the value for the `switch expression`
                }
                default -> 0;
            };
            System.out.println("Month " + month + " has " + result + " days.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid month name entered.");
        } finally {
            scanner.close();
        }
    }
}
