package org.workspace.exercise.oop.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO student (name, age, country, class_name) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getCountry());
            pstmt.setString(4, student.getClassName());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // Lấy ID vừa được tạo
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    System.out.println("✓ Student added with ID: " + rs.getInt(1));
                }
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println("✗ Error adding student: " + e.getMessage());
            return false;
        }
    }

    public boolean updateStudent(int id, Student student) {
        String sql = "UPDATE student SET name = ?, age = ?, country = ?, class_name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getCountry());
            pstmt.setString(4, student.getClassName());
            pstmt.setInt(5, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("✗ Error updating student: " + e.getMessage());
            return false;
        }
    }

    // Xóa sinh viên theo id
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("✗ Error deleting student: " + e.getMessage());
            return false;
        }
    }

    // Tìm sinh viên theo id
    public Student findStudentById(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("country"),
                        rs.getString("class_name")
                );
            }

        } catch (SQLException e) {
            System.err.println("✗ Error finding student: " + e.getMessage());
        }
        return null;
    }

    // Tìm kiếm sinh viên theo tên
    public List<Student> searchStudentByName(String name) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE name LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("country"),
                        rs.getString("class_name")
                ));
            }

        } catch (SQLException e) {
            System.err.println("✗ Error searching students: " + e.getMessage());
        }
        return students;
    }

    // Hiển thị tất cả sinh viên
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("country"),
                        rs.getString("class_name")
                ));
            }

        } catch (SQLException e) {
            System.err.println("✗ Error getting all students: " + e.getMessage());
        }
        return students;
    }

    // Kiểm tra có sinh viên độ tuổi cụ thể không
    public boolean hasStudentWithAge(int age) {
        String sql = "SELECT COUNT(*) FROM student WHERE age = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, age);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.err.println("✗ Error checking student age: " + e.getMessage());
        }
        return false;
    }

    // Đếm sinh viên theo độ tuổi và quốc gia
    public int countStudentsByAgeAndCountry(int age, String country) {
        String sql = "SELECT COUNT(*) FROM student WHERE age = ? AND country = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, age);
            pstmt.setString(2, country);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("✗ Error counting students: " + e.getMessage());
        }
        return 0;
    }
}
