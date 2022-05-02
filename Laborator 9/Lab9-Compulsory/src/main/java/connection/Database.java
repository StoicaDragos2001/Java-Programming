package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class to manage a connection to the database
 */
public class Database {
    private static final String dbURL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String username = "STUDENT";
    private static final String password = "STUDENT";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        return connection;
    }

    /**
     * Creates a connection to the database based on url, username and password
     */
    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            connection.setAutoCommit(false);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the connection to the database
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void rollback() {
    }
}
