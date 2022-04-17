import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbURL="jdbc:oracle:thin:@localhost:1521/xe";
        String username="STUDENT";
        String password="STUDENT";
        try  {Connection connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
