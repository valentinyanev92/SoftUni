package Exercises;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetMinionsNameByVillianID {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = getConnection();

        System.out.print("Enter villain's ID: ");
        int villainId = scanner.nextInt();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.name, m.age, v.name " +
                "FROM villains v " +
                "JOIN minions_villains mv ON mv.villain_id = v.id " +
                "JOIN minions m ON m.id = mv.minion_id " +
                "WHERE v.id = ?;");

        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Villain: " + resultSet.getString("v.name"));

            int counter = 2;
            System.out.println("1. " + resultSet.getString("m.name") + " " + resultSet.getInt("m.age"));
            while (resultSet.next()) {
                System.out.println(counter + ". " + resultSet.getString("m.name") + " " + resultSet.getInt("m.age"));
                counter++;
            }

        }else {
            System.out.println("No villain with id " + villainId + " exist in the database");
        }
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/minions_db";

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "root");

        Connection connection = (Connection) DriverManager.getConnection(url, props);
        return connection;
    }

}
