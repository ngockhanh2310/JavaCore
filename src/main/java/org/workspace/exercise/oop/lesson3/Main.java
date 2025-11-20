package org.workspace.exercise.oop.lesson3;

import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        DatabaseConfig.initDatabase();

        Scanner scanner = new Scanner(in);
        ManageVehicle manager = new ManageVehicle();

        while (true) {
            out.println("\n╔════════════════════════════════════╗");
            out.println("║  VEHICLE MANAGEMENT SYSTEM (DB)    ║");
            out.println("╠════════════════════════════════════╣");
            out.println("║ 1. Add Vehicle                     ║");
            out.println("║ 2. Remove Vehicle by ID            ║");
            out.println("║ 3. Search by Manufacturer          ║");
            out.println("║ 4. Search by Color                 ║");
            out.println("║ 5. Display All Vehicles            ║");
            out.println("║ 6. Statistics                      ║");
            out.println("║ 0. Exit                            ║");
            out.println("╚════════════════════════════════════╝");
            out.print("Select option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                out.println("✗ Please enter a number!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> manager.addVehicle(scanner);
                case 2 -> manager.removeVehicle(scanner);
                case 3 -> manager.searchByManufacturer(scanner);
                case 4 -> manager.searchByColor(scanner);
                case 5 -> manager.display();
                case 6 -> manager.statistics();
                case 0 -> {
                    out.println("\nExit system!");
                    scanner.close();
                    exit(0);
                }
                default -> out.println("✗ Invalid option!");
            }
        }
    }
}

