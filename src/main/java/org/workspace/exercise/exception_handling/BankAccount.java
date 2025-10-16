package org.workspace.exercise.exception_handling;

import javax.naming.InsufficientResourcesException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    static long balance = 1000000;

    public static void main(String[] args) {
        long money;
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            try {
                System.out.print("Enter withdrawal amount:");
                money = scanner.nextLong();
                if (money < 0) {
                    System.out.println("Withdrawal amount must be greater than 0!");
                    continue;
                }
                if (money > balance) {
                    throw new InsufficientResourcesException("Insufficient balance");
                }

                System.out.println("Successful withdrawal : " + money + "VND.");
                System.out.println("Current balance : " + (balance - money) + "VND.");
                check = true;
            } catch (InsufficientResourcesException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
