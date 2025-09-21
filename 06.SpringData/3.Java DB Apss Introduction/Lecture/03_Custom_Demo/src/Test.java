import java.sql.*;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws SQLException {

        // Connect to SQL server
        String jdbcUrl = "jdbc:mysql://localhost:3306/soft_uni";
        String username = "root";
        String password = "root";

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection(jdbcUrl, props);

        // Execute query

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees LIMIT 10");
        ResultSet resultSet = preparedStatement.executeQuery();

        // Parse result

        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String job_title = resultSet.getString("job_title");
            double salary = resultSet.getDouble("salary");

            System.out.printf("%s %s - %.2f%n", firstName, job_title, salary);
        }

    }
}