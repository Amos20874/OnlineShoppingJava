import java.sql.Connection;
import java.sql.PreparedStatement;

public class register {
    public boolean register(String name, String email, String password, String phone, String address) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (name, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, phone);
            stmt.setString(5, address);

            int rows = stmt.executeUpdate();
            return rows > 0; // true if registration worked
        } catch (Exception e) {
            e.printStackTrace();
            return false;
 }
}
}
