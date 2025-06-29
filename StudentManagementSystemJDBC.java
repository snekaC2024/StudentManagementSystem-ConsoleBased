import java.sql.*;
import java.util.*;

public class StudentManagementSystemJDBC {
    static Scanner sc = new Scanner(System.in);
    static final String DB_URL = "jdbc:mysql://localhost:3306/student_db";
    static final String DB_USER = "root"; // change if needed
    static final String DB_PASS = ""; // change to your MySQL password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            int choice;
            do {
                System.out.println("\n---- Student Management System (JDBC) ----");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Delete Student");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                case 1:
                  addStudent(conn);
                  break;
                case 2:
                  viewStudents(conn);
                  break;
                case 3:
                  deleteStudent(conn);
                  break;
                case 4:
                  System.out.println("Exiting...");
                  break;
                default:
                  System.out.println("Invalid choice.");
                  break;
                }

            } while (choice != 4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addStudent(Connection conn) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Student added!" : "Failed to add student.");
        }
    }

    static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n-- Student List --");
            System.out.println("+----+--------------+-----+");
            System.out.printf("| %-2s | %-12s | %-3s |\n", "ID", "Name", "Age");
            System.out.println("+----+--------------+-----+");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.printf("| %-2d | %-12s | %-3d |\n", id, name, age);
            }

            System.out.println("+----+--------------+-----+");

        }
    }

    static void deleteStudent(Connection conn) throws SQLException {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Student deleted." : "Student not found.");
        }
    }
}
