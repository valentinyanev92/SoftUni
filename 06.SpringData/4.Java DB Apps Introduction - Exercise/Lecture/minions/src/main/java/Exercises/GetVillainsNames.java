package Exercises;

import java.sql.*;
import java.util.Properties;


public class GetVillainsNames {

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "SELECT v.name, COUNT(mv.villain_id) as counter " +
                "FROM villains v " +
                "JOIN minions_villains mv WHERE v.id = mv.villain_id " +
                "GROUP BY v.id " +
                "ORDER BY counter DESC;");

        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("counter"));
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
