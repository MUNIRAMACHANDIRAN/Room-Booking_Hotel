import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 🔥 IMPORTANT
        String url = "jdbc:mysql://localhost:3306/hotel_db?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "1234"; // change this
        return DriverManager.getConnection(url, user, pass);
    }
}
