package org.workspace.learn.basic.control_flow.decision_statements;

public class SwitchExample {
    public static void main(String[] args) {
        int day = 3;

        // Use switch to choose day name
        switch (day) {
            case 2:
                System.out.println("Monday!");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            case 8:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("The number entered does not correspond to any day of the week.");
                break;
        }
    }
}
