package org.workspace.exercise.oop.lesson3;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class ManageVehicle {
    private final VehicleDAO vehicleDAO;

    public ManageVehicle() {
        this.vehicleDAO = new VehicleDAO();
    }

    public String randomID(String prefix) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 12;
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return prefix + randomString;
    }

    public void addVehicle(Scanner scanner) {
        out.println("\n╔════════════════════════════════════╗");
        out.println("║        ADD VEHICLE                 ║");
        out.println("╚════════════════════════════════════╝");
        out.println("1. ADD CAR");
        out.println("2. ADD MOTORBIKE");
        out.println("3. ADD TRUCK");
        out.print("Select option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        String manufacturer, color, id;
        int yearOfManufacturer;
        double price;
        Vehicle vehicle = null;

        switch (choice) {
            case 1 -> {
                out.print("Enter manufacturer: ");
                manufacturer = scanner.nextLine();
                out.print("Enter year of manufacturer: ");
                yearOfManufacturer = scanner.nextInt();
                out.print("Enter price: ");
                price = scanner.nextDouble();
                scanner.nextLine();
                out.print("Enter color: ");
                color = scanner.nextLine();
                out.print("Enter seats: ");
                int seats = scanner.nextInt();
                scanner.nextLine();
                out.print("Enter engine: ");
                String engine = scanner.nextLine();

                id = randomID("CAR-");
                vehicle = Car.builder()
                        .id(id)
                        .manufacturer(manufacturer)
                        .yearOfManufacturer(yearOfManufacturer)
                        .price(price)
                        .color(color)
                        .seats(seats)
                        .engine(engine)
                        .build();
            }
            case 2 -> {
                out.print("Enter manufacturer: ");
                manufacturer = scanner.nextLine();
                out.print("Enter year of manufacturer: ");
                yearOfManufacturer = scanner.nextInt();
                out.print("Enter price: ");
                price = scanner.nextDouble();
                scanner.nextLine();
                out.print("Enter color: ");
                color = scanner.nextLine();
                out.print("Enter capacity (cc): ");
                int capacity = scanner.nextInt();
                scanner.nextLine();

                id = randomID("MOTOR-");
                vehicle = Motor.builder()
                        .id(id)
                        .manufacturer(manufacturer)
                        .yearOfManufacturer(yearOfManufacturer)
                        .price(price)
                        .color(color)
                        .capacity(capacity)
                        .build();
            }
            case 3 -> {
                out.print("Enter manufacturer: ");
                manufacturer = scanner.nextLine();
                out.print("Enter year of manufacturer: ");
                yearOfManufacturer = scanner.nextInt();
                out.print("Enter price: ");
                price = scanner.nextDouble();
                scanner.nextLine();
                out.print("Enter color: ");
                color = scanner.nextLine();
                out.print("Enter tonnage (tons): ");
                double tonnage = scanner.nextDouble();
                scanner.nextLine();

                id = randomID("TRUCK-");
                vehicle = Truck.builder()
                        .id(id)
                        .manufacturer(manufacturer)
                        .yearOfManufacturer(yearOfManufacturer)
                        .price(price)
                        .color(color)
                        .tonnage(tonnage)
                        .build();
            }
            default -> {
                out.println("✗ Invalid choice!");
                return;
            }
        }

        if (vehicle != null && vehicleDAO.save(vehicle)) {
            out.println("\n✓ Vehicle added successfully!");
            out.println("Generated ID: " + vehicle.getId());
        } else {
            out.println("\n✗ Failed to add vehicle!");
        }
    }

    public void removeVehicle(Scanner scanner) {
        out.print("\nEnter vehicle ID to remove: ");
        String id = scanner.nextLine();

        if (vehicleDAO.delete(id)) {
            out.println("✓ Vehicle removed successfully!");
        } else {
            out.println("✗ Vehicle not found or delete failed!");
        }
    }

    public void searchByManufacturer(Scanner scanner) {
        out.print("\nEnter manufacturer: ");
        String manufacturer = scanner.nextLine();
        List<Vehicle> results = vehicleDAO.findByManufacturer(manufacturer);

        if (results.isEmpty())
            out.println("✗ No vehicles found!");
        else {
            out.println("\n✓ Found " + results.size() + " vehicle(s):");
            results.forEach(out::println);
        }
    }

    public void searchByColor(Scanner scanner) {
        out.print("\nEnter color: ");
        String color = scanner.nextLine();
        List<Vehicle> results = vehicleDAO.findByColor(color);

        if (results.isEmpty())
            out.println("✗ No vehicles found!");
        else {
            out.println("\n✓ Found " + results.size() + " vehicle(s):");
            results.forEach(out::println);
        }
    }

    public void display() {
        List<Vehicle> vehicles = vehicleDAO.findAll();

        if (vehicles.isEmpty()) {
            out.println("\n✗ No vehicles in database!");
            return;
        }

        out.println("\n╔════════════════════════════════════╗");
        out.println("║     ALL VEHICLES (" + vehicles.size() + ")            ║");
        out.println("╚════════════════════════════════════╝");
        vehicles.forEach(out::println);
    }

    public void statistics() {
        List<Vehicle> vehicles = vehicleDAO.findAll();

        long carCount = vehicles.stream().filter(v -> v instanceof Car).count();
        long motorCount = vehicles.stream().filter(v -> v instanceof Motor).count();
        long truckCount = vehicles.stream().filter(v -> v instanceof Truck).count();

        out.println("\n╔════════════════════════════════════╗");
        out.println("║         STATISTICS                 ║");
        out.println("╠════════════════════════════════════╣");
        out.println("║ Total vehicles: " + vehicles.size());
        out.println("║ - Cars: " + carCount);
        out.println("║ - Motorbikes: " + motorCount);
        out.println("║ - Trucks: " + truckCount);
        out.println("╚════════════════════════════════════╝");
    }
}

