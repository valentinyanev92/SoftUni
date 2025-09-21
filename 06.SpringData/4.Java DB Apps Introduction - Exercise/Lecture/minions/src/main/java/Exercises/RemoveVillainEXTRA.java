//package Exercises;
//
//import java.sql.*;
//import java.util.Properties;
//import java.util.Scanner;
//
//public class RemoveVillainEXTRA {
//
//    public static void main(String[] args) throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        Connection connection = getConnection();
//
//        System.out.print("Enter the villain's id: ");
//        int villainId = scanner.nextInt();
//
//        PreparedStatement preparedStatement = connection.prepareStatement
//                ("SELECT * " +
//                "FROM villains v " +
//                "JOIN minions_villains mv ON v.id = mv.villain_id " +
//                "JOIN minions m ON m.id = mv.minion_id " +
//                "WHERE v.id = ? " +
//                "ORDER BY m.id");
//        preparedStatement.setInt(1, villainId);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        if (resultSet.next()) {
//            connection.setAutoCommit(false);
//
//            PreparedStatement countMinions = connection.prepareStatement("SELECT COUNT(*) FROM minions_villains WHERE villain_id = ?");
//            countMinions.setInt(1, villainId);
//            resultSet = countMinions.executeQuery();
//            resultSet.next();
//            int minionsCount = resultSet.getInt(1);
//            int minionsDeleted = 0;
//
//            PreparedStatement findMinions = connection.prepareStatement("SELECT minion_id FROM minions_villains WHERE villain_id = ?");
//            findMinions.setInt(1, villainId);
//            resultSet = findMinions.executeQuery();
//
//            while (resultSet.next()) {
//                int currentMinionId = resultSet.getInt(1);
//                PreparedStatement deleteFromMinions = connection.prepareStatement("DELETE * FROM minions WHERE id = ?");
//                deleteFromMinions.setInt(1, currentMinionId);
//                deleteFromMinions.executeUpdate();
//
//                PreparedStatement deleteFromMinionsVillains = connection.prepareStatement("DELETE * FROM minions_villains WHERE id = ?");
//                deleteFromMinionsVillains.setInt(1, currentMinionId);
//                deleteFromMinionsVillains.executeUpdate();
//
//                minionsDeleted++;
//            }
//
//            PreparedStatement deleteVillain = connection.prepareStatement("DELETE * FROM villains WHERE id = ?");
//            deleteVillain.setInt(1, villainId);
//            deleteVillain.executeUpdate();
//
//            if (minionsDeleted == minionsCount) {
//                connection.commit();
//
//                PreparedStatement villian = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
//                villian.setInt(1, villainId);
//                villian.executeUpdate();
//                ResultSet villains = villian.getResultSet();
//
//                System.out.println("Villain " + villains.getString("name") + " has been deleted.");
//                System.out.println(countMinions + " minions have been released.");
//            }else {
//                System.out.println("No such villain was found.");
//                connection.rollback();
//            }
//        }
//
//
//
//
//    }
//
//    private static Connection getConnection() throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/minions_db";
//
//        Properties props = new Properties();
//        props.setProperty("user", "root");
//        props.setProperty("password", "root");
//
//        Connection connection = (Connection) DriverManager.getConnection(url, props);
//        return connection;
//    }
//}
