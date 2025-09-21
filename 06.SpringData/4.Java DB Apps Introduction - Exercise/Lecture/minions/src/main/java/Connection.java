import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Connection {

    public static void main(String[] args) throws SQLException {

    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/minions_db";

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "root");

        Connection connection = (Connection) DriverManager.getConnection(url, props);
        return connection;
    }


}

