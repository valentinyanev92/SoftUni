package Exercises;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class ChangeTownNameCasing {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = getConnection();

        System.out.print("Enter country name: ");
        String townName = scanner.nextLine();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, COUNT(id) " +
                "FROM towns " +
                "WHERE country = ? " +
                "GROUP BY id");
        preparedStatement.setString(1, townName);
        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        ArrayList<String> townNames = new ArrayList<>();

        while (resultSet.next()) {

            int currentId = resultSet.getInt("id");
            PreparedStatement modifiedStatement = connection.prepareStatement("UPDATE towns SET name = ? WHERE id = ?");
            modifiedStatement.setString(1, resultSet.getString("name").toUpperCase());
            modifiedStatement.setInt(2, currentId);
            modifiedStatement.executeUpdate();
            modifiedStatement.close();

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT name FROM towns WHERE id = ?");
            preparedStatement2.setInt(1, currentId);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            resultSet2.next();
            townNames.add(resultSet2.getString("name"));
            count++;
        }

        if (townNames.size() > 0) {
            System.out.println(townNames.size() + " town names were affected.");
            System.out.println(townNames);
        } else {
            System.out.println("No town names were affected.");
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
