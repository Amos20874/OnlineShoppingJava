import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Change the DB name, username, and password if different
    private static final String URL = "jdbc:mysql://localhost:3306/ordering_app?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // XAMPP default user
    private static final String PASSWORD = ""; // XAMPP default has no password

    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to get a database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
}
}