package Exercises;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class AddMinion {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = getConnection();

        System.out.print("Minion: ");
        String[] minionInput = scanner.nextLine().split(" ");
        String minionName = minionInput[0];
        int minionAge = Integer.parseInt(minionInput[1]);
        String minionTown = minionInput[2];

        System.out.print("Villain: ");
        String villainName = scanner.nextLine();

        PreparedStatement getVillain = connection.prepareStatement("SELECT * FROM villains WHERE name = ?");
        getVillain.setString(1, villainName);
        ResultSet villainResult = getVillain.executeQuery();
        int villainId  = createAndGetIdVillain(villainResult, connection, villainName);

        PreparedStatement getTown = connection.prepareStatement("SELECT * FROM towns WHERE name = ?");
        getTown.setString(1, minionTown);
        ResultSet townResult = getTown.executeQuery();
        int townId = createAndGetTownId(townResult, connection, minionTown);

        CreateMinion(connection, minionName, minionAge, townId);

        int minionId = getMinionId(connection, minionName);

        ConnectMinionToVillain(connection, minionId, villainId, minionName, villainName);
    }

    private static void ConnectMinionToVillain(Connection connection, int minionId, int villainId, String minionName, String villainName) throws SQLException {
        PreparedStatement addMinionToVillain = connection.prepareStatement("INSERT INTO minions_villains(minion_id, villain_id) VALUES (?, ?)");
        addMinionToVillain.setInt(1, minionId);
        addMinionToVillain.setInt(2, villainId);
        addMinionToVillain.executeUpdate();
        System.out.println("Successfully added " + minionName + " to be minion of " + villainName + ".");
    }

    private static int getMinionId(Connection connection, String minionName) throws SQLException {
        int minionId;
        PreparedStatement getMinionId = connection.prepareStatement("SELECT * FROM minions WHERE name = ?");
        getMinionId.setString(1, minionName);
        ResultSet minionResult = getMinionId.executeQuery();
        minionResult.next();
        minionId = minionResult.getInt("id");
        return minionId;
    }

    private static void CreateMinion(Connection connection, String minionName, int minionAge, int townId) throws SQLException {
        PreparedStatement createMinion = connection.prepareStatement("INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?)");
        createMinion.setString(1, minionName);
        createMinion.setInt(2, minionAge);
        createMinion.setInt(3, townId);
        createMinion.executeUpdate();
        System.out.println("Minion " + minionName + " was added to the database.");
    }

    private static int createAndGetTownId(ResultSet townResult, Connection connection, String minionTown) throws SQLException {
        int townId;
        if (!townResult.next()) {
            PreparedStatement createTown = connection.prepareStatement("INSERT INTO towns (name) VALUES (?)");
            createTown.setString(1, minionTown);
            createTown.executeUpdate();

            System.out.println("Town " + minionTown + " was added to the database.");

            PreparedStatement getTownId = connection.prepareStatement("SELECT * FROM towns WHERE name = ?");
            getTownId.setString(1, minionTown);
            ResultSet townIdResult = getTownId.executeQuery();
            townIdResult.next();
            townId = townIdResult.getInt(1);
        } else {
            townId = townResult.getInt("id");
        }
        return townId;
    }

    private static int createAndGetIdVillain(ResultSet villainResult, Connection connection, String villainName) throws SQLException {
        int villainId;
        if (!villainResult.next()) {
            PreparedStatement createVillain = connection.prepareStatement("INSERT INTO villains(name, evilness_factor) VALUES (?, ?)");
            createVillain.setString(1, villainName);
            createVillain.setString(2, "evil");
            createVillain.executeUpdate();

            System.out.println("Villain " + villainName + " was added to the database.");

            PreparedStatement getVillainId = connection.prepareStatement("SELECT * FROM villains WHERE name = ?");
            getVillainId.setString(1, villainName);
            ResultSet villainIdResult = getVillainId.executeQuery();
            villainIdResult.next();
            villainId = villainIdResult.getInt(1);
        }else {
            villainId = villainResult.getInt("id");
        }
        return villainId;
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