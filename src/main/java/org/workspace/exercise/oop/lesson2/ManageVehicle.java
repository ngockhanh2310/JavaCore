package org.workspace.exercise.oop.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ManageVehicle {
    private List<Vehicle> vehicles;

    public ManageVehicle() {
        this.vehicles = new ArrayList<Vehicle>();
    }

    private static void accept(Vehicle vehicle) {
        System.out.println(vehicle.toString());
    }

    public String randomID(String id) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 12;
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return id + randomString;
        //region- random number
        //int randNum = rand.nextInt(9000000) + 1000000;
        //return id + randNum;
        //endregion
    }

    public void addVehicle(Scanner scanner) {
        String id;
        String manufacturer;
        int yearOfManufacturer;
        double price;
        String color;

        System.out.println("\n=== ADD VEHICLE ===");
        System.out.println("1. ADD CAR");
        System.out.println("2. ADD MOTORBIKE");
        System.out.println("3. ADD TRUCK");
        System.out.print("Select options: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter manufacturer:");
                manufacturer = scanner.nextLine();
                System.out.print("Enter year of manufacturer:");
                yearOfManufacturer = scanner.nextInt();
                System.out.print("Enter price:");
                price = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter color:");
                color = scanner.nextLine();
                System.out.print("Enter seats:");
                int seats = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter engine:");
                String engine = scanner.nextLine();
                id = randomID("CAR-");
                new Car();
                vehicles.add(Car.builder()
                        .id(id)
                        .manufacturer(manufacturer)
                        .yearOfManufacturer(yearOfManufacturer)
                        .price(price)
                        .color(color)
                        .seats(seats)
                        .engine(engine)
                        .build());
                System.out.println("---More success---");
                break;
            case 2:
                System.out.print("Enter manufacturer:");
                manufacturer = scanner.nextLine();
                System.out.print("Enter year of manufacturer:");
                yearOfManufacturer = scanner.nextInt();
                System.out.print("Enter price:");
                price = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter color:");
                color = scanner.nextLine();
                id = randomID("MOTOR-");
                System.out.print("Enter capacity:");
                int capacity = scanner.nextInt();
                scanner.nextLine();
                new Motor();
                vehicles.add(Motor.builder()
                        .id(id)
                        .manufacturer(manufacturer)
                        .yearOfManufacturer(yearOfManufacturer)
                        .price(price)
                        .color(color)
                        .capacity(capacity)
                        .build());
                System.out.println("---More success---");
                break;
            case 3:
                System.out.print("Enter manufacturer:");
                manufacturer = scanner.nextLine();
                System.out.print("Enter year of manufacturer:");
                yearOfManufacturer = scanner.nextInt();
                System.out.print("Enter price:");
                price = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter color:");
                color = scanner.nextLine();
                id = randomID("TRUCK-");
                System.out.print("Enter tonnage:");
                double tonnage = scanner.nextDouble();
                scanner.nextLine();
                new Truck();
                vehicles.add(Truck.builder()
                        .id(id)
                        .manufacturer(manufacturer)
                        .yearOfManufacturer(yearOfManufacturer)
                        .price(price)
                        .color(color)
                        .tonnage(tonnage)
                        .build());
                System.out.println("---More success---");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public void removeVehicle(Scanner scanner) {
        System.out.print("\nEnter vehicle ID to remove: ");
        String id = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId().equals(id)) {
                vehicles.remove(i);
                System.out.println("✓ Vehicle removed successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ Vehicle not found with ID: " + id);
        }
    }

    // Tìm kiếm theo hãng sản xuất
    public void searchByManufacturer(Scanner scanner) {
        System.out.print("\nEnter manufacturer: ");
        String manufacturer = scanner.nextLine();

        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getManufacturer().equalsIgnoreCase(manufacturer)) {
                results.add(v);
            }
        }

        if (results.isEmpty()) {
            System.out.println("✗ No vehicles found from manufacturer: " + manufacturer);
        } else {
            System.out.println("\n✓ Found " + results.size() + " vehicle(s):");
            results.forEach(System.out::println);
        }
    }

    // Tìm kiếm theo màu
    public void searchByColor(Scanner scanner) {
        System.out.print("\nEnter color: ");
        String color = scanner.nextLine();

        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getColor().equalsIgnoreCase(color)) {
                results.add(v);
            }
        }

        if (results.isEmpty()) {
            System.out.println("✗ No vehicles found with color: " + color);
        } else {
            System.out.println("\n✓ Found " + results.size() + " vehicle(s):");
            results.forEach(System.out::println);
        }
    }

    // Hiển thị tất cả
    public void display() {
        if (vehicles.isEmpty()) {
            System.out.println("\n✗ No vehicles in the system!");
            return;
        }

        System.out.println("\n════════════════════════════════════");
        System.out.println("     ALL VEHICLES (" + vehicles.size() + ")            ");
        System.out.println("════════════════════════════════════");
        vehicles.forEach(System.out::println);
    }

    public void statistics() {
        long carCount = vehicles.stream().filter(v -> v instanceof Car).count();
        long motorCount = vehicles.stream().filter(v -> v instanceof Motor).count();
        long truckCount = vehicles.stream().filter(v -> v instanceof Truck).count();

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         STATISTICS                 ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Total vehicles: " + vehicles.size());
        System.out.println("║ - Cars: " + carCount);
        System.out.println("║ - Motorbikes: " + motorCount);
        System.out.println("║ - Trucks: " + truckCount);
        System.out.println("╚════════════════════════════════════╝");
    }
}
