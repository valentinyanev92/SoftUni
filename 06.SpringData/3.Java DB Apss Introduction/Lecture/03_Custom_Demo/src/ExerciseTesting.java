import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class ExerciseTesting {
    static String jdbc = "jdbc:mysql://localhost:3306/soft_uni";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();

        System.out.print("Username : ");
        String username = scanner.nextLine();
        username = username.isEmpty() ? "root" : username;
        properties.setProperty("user", username);

        System.out.print("Password : ");
        properties.setProperty("password", scanner.nextLine());

        Connection connection = DriverManager.getConnection(jdbc, properties);

        System.out.print("Enter salary : ");
        double salary = scanner.nextDouble();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE SALARY > ?");
        preparedStatement.setDouble(1, salary);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %s - %.2f %n", resultSet.getString("first_name"),
                    resultSet.getString("last_name"), resultSet.getDouble("salary"));
        }

    }
}
