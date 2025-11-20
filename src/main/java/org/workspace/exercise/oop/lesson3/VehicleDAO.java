package org.workspace.exercise.oop.lesson3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    public boolean save(Vehicle vehicle) {
        String sql = """
                    INSERT INTO vehicles 
                    (id, manufacturer, year_of_manufacturer, price, color, vehicle_type, 
                     seats, engine, capacity, tonnage)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicle.getId());
            pstmt.setString(2, vehicle.getManufacturer());
            pstmt.setInt(3, vehicle.getYearOfManufacturer());
            pstmt.setDouble(4, vehicle.getPrice());
            pstmt.setString(5, vehicle.getColor());
            pstmt.setString(6, vehicle.getVehicleType());

            if (vehicle instanceof Car car) {
                pstmt.setInt(7, car.getSeats());
                pstmt.setString(8, car.getEngine());
                pstmt.setNull(9, Types.INTEGER);
                pstmt.setNull(10, Types.DOUBLE);
            } else if (vehicle instanceof Motor motor) {
                pstmt.setNull(7, Types.INTEGER);
                pstmt.setNull(8, Types.VARCHAR);
                pstmt.setInt(9, motor.getCapacity());
                pstmt.setNull(10, Types.DOUBLE);
            } else if (vehicle instanceof Truck truck) {
                pstmt.setNull(7, Types.INTEGER);
                pstmt.setNull(8, Types.VARCHAR);
                pstmt.setNull(9, Types.INTEGER);
                pstmt.setDouble(10, truck.getTonnage());
            }

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("✗ Save error: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("✗ Delete error: " + e.getMessage());
            return false;
        }
    }

    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }

        } catch (SQLException e) {
            System.err.println("✗ Query error: " + e.getMessage());
        }

        return vehicles;
    }

    public List<Vehicle> findByManufacturer(String manufacturer) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE LOWER(manufacturer) = LOWER(?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, manufacturer);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }

        } catch (SQLException e) {
            System.err.println("✗ Query error: " + e.getMessage());
        }

        return vehicles;
    }

    public List<Vehicle> findByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE LOWER(color) = LOWER(?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, color);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }

        } catch (SQLException e) {
            System.err.println("✗ Query error: " + e.getMessage());
        }

        return vehicles;
    }

    private Vehicle mapResultSetToVehicle(ResultSet rs) throws SQLException {
        String type = rs.getString("vehicle_type");

        return switch (type) {
            case "Car" -> Car.builder()
                    .id(rs.getString("id"))
                    .manufacturer(rs.getString("manufacturer"))
                    .yearOfManufacturer(rs.getInt("year_of_manufacturer"))
                    .price(rs.getDouble("price"))
                    .color(rs.getString("color"))
                    .seats(rs.getInt("seats"))
                    .engine(rs.getString("engine"))
                    .build();

            case "Motor" -> Motor.builder()
                    .id(rs.getString("id"))
                    .manufacturer(rs.getString("manufacturer"))
                    .yearOfManufacturer(rs.getInt("year_of_manufacturer"))
                    .price(rs.getDouble("price"))
                    .color(rs.getString("color"))
                    .capacity(rs.getInt("capacity"))
                    .build();

            case "Truck" -> Truck.builder()
                    .id(rs.getString("id"))
                    .manufacturer(rs.getString("manufacturer"))
                    .yearOfManufacturer(rs.getInt("year_of_manufacturer"))
                    .price(rs.getDouble("price"))
                    .color(rs.getString("color"))
                    .tonnage(rs.getDouble("tonnage"))
                    .build();

            default -> null;
        };
    }
}

