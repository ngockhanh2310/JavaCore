package org.workspace.exercise.oop.lesson3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/lesson";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initDatabase() {
        String createVehicleTable = """
                    CREATE TABLE IF NOT EXISTS vehicles (
                        id VARCHAR(50) PRIMARY KEY,
                        manufacturer VARCHAR(100),
                        year_of_manufacturer INT,
                        price DOUBLE,
                        color VARCHAR(50),
                        vehicle_type VARCHAR(20),
                        seats INT,
                        engine VARCHAR(100),
                        capacity INT,
                        tonnage DOUBLE
                    )
                """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createVehicleTable);
            System.out.println("✓ Database initialized successfully!");
        } catch (SQLException e) {
            System.err.println("✗ Database initialization error: " + e.getMessage());
        }
    }
}

