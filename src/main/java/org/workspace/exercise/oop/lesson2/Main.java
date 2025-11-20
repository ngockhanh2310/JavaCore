package org.workspace.exercise.oop.lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageVehicle manager = new ManageVehicle();

        while (true) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║  VEHICLE MANAGEMENT SYSTEM         ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1. Add Vehicle                     ║");
            System.out.println("║ 2. Remove Vehicle by ID            ║");
            System.out.println("║ 3. Search by Manufacturer          ║");
            System.out.println("║ 4. Search by Color                 ║");
            System.out.println("║ 5. Display All Vehicles            ║");
            System.out.println("║ 6. Statistics                      ║");
            System.out.println("║ 0. Exit                            ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("Select option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("✗ Please enter a number!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    manager.addVehicle(scanner);
                    break;
                case 2:
                    manager.removeVehicle(scanner);
                    break;
                case 3:
                    manager.searchByManufacturer(scanner);
                    break;
                case 4:
                    manager.searchByColor(scanner);
                    break;
                case 5:
                    manager.display();
                    break;
                case 6:
                    manager.statistics();
                    break;
                case 0:
                    System.out.println("\n👋 Thank you for using the system!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("✗ Invalid option!");
            }
        }
    }
}
