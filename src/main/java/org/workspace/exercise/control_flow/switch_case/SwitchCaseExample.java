package org.workspace.exercise.control_flow.switch_case;

import java.time.Month;
import java.util.Scanner;

public class SwitchCaseExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month name (e.g., JANUARY):");
        String monthName = scanner.nextLine().toUpperCase();

        // Chuyển đổi chuỗi nhập vào thành Month enum
        try {
            Month month = Month.valueOf(monthName);

            // Switch Expression trên Enum: không cần default nếu bao phủ hết các case
            var result = switch (month) {
                case JANUARY, JUNE, JULY -> 3;
                case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> 1;
                case MARCH, MAY, APRIL, AUGUST -> 2;
                // Không cần 'default' vì enum Month đã được bao phủ hết các giá trị
                // Nếu muốn xử lý linh hoạt hơn, bạn có thể thêm 'default' để throw Exception
            };

            System.out.println("Result: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid month name entered.");
        } finally {
            scanner.close();
        }
    }
}
