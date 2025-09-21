package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {

    private static Connection connection;
    private static final String connectionString = "jdbc:mysql://localhost:3306/%s";

    public static void createConnection(String username, String password, String dbName) throws SQLException {

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        connection = DriverManager.getConnection(String.format(connectionString, dbName), props);
    }

    public static Connection getConnection() {
        return connection;
    }

}
