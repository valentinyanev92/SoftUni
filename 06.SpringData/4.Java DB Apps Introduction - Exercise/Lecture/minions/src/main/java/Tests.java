import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Tests {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/diablo";

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "root");

        Connection connection = DriverManager.getConnection(url, props);

    }
}
