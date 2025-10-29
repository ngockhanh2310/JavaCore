package org.workspace.exercise.oop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/lesson";
    private static final String USER = "root";
    private static final String PASS = "root";

    // Lấy kết nối đến database
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
    }

    // Test kết nối
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("✓ Connected to database successfully!");
            return true;
        } catch (SQLException e) {
            System.err.println("✗ Connection failed: " + e.getMessage());
            return false;
        }
    }
}
