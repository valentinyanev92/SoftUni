package Exercises;

import java.sql.*;
import java.util.Properties;

public class PrintAllMinions {

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();

        Statement ps = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = ps.executeQuery("SELECT * FROM minions");

//        PreparedStatement ps = connection.prepareStatement("SELECT name FROM Minions ORDER BY id");
//        ResultSet rs = ps.executeQuery();

        int start = 1;
        rs.last();
        int end = rs.getRow();


        while (start <= end) {
            rs.absolute(start);
            System.out.println(rs.getString("name"));

            if (start != end) {
                rs.absolute(end);
                System.out.println(rs.getString("name"));
            }
            start++;
            end--;
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
