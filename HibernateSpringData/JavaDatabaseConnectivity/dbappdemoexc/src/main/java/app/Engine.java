package app;

import java.sql.*;
import java.util.Scanner;

public class Engine implements Runnable {

    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            this.addMinion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//           this.getVillainsNames();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    //    Problem 1
    private void getVillainsNames() throws SQLException {
        String query = "SELECT v.name, COUNT(mv.minion_id) AS `output` FROM villains AS v JOIn minions_villains AS `mv` on v.id = mv.villain_id GROUP BY v.name HAVING output > ? ORDER BY output DESC";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(String.format("%s %d", resultSet.getString(1), resultSet.getInt(2)));
        }
    }


    //    Problem 4 Add minion
    private void addMinion() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String[] minionParams = scanner.nextLine().split("\\s+");
        String[] villainParams = scanner.nextLine().split("\\s+");

        String minionName = minionParams[1];
        int minionAge = Integer.parseInt(minionParams[2]);
        String minionTown = minionParams[3];
        String villainName = villainParams[1];

        if (!checkIfEntityExists(minionTown, "towns")) {
            this.insertTown(minionTown);
        }
        if (!checkIfEntityExists(villainName, "villains")) {
            this.insertVillain(villainName);
        }

        int townId = this.getEntityId(minionTown, "towns");

        this.insertMinion(minionName, minionAge, townId);

        int minionId = this.getEntityId(minionName, "minions");
        int villainId = this.getEntityId(villainName, "villains");

        this.hireMinion(minionId, villainId);

        System.out.println(String.format("Successfully added %s to be minion of %s.",minionName, villainName));


    }

    private boolean checkIfEntityExists(String name, String tableName) throws SQLException {

        String query = "SELECT * FROM " + tableName + " AS t WHERE t.name = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }

    private void insertTown(String townName) throws SQLException {
        String query = "INSERT INTO towns(name, country) VALUES('" + townName + "',NULL)";

        PreparedStatement preparedStatement= this.connection.prepareStatement(query);

        preparedStatement.execute();
        System.out.println(String.format("Town %s was added to the database.", townName));
    }


    private void insertVillain(String villainName) throws SQLException {
        String query = String.format("INSERT INTO villains(name,evilness_factor) VALUES('%s', 'evil')",villainName);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
        System.out.println(String.format("Villain %s was added to the database.", villainName));
    }

    private int getEntityId(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = '%s'",tableName,name);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next(); // kursora da premestim na purviq element;

        return resultSet.getInt(1);
    }

    private void insertMinion(String minionName, int age, int townId) throws SQLException {
        String query = String.format("INSERT INTO minions(name,age,town_id) VALUES('%s', %d, %d)", minionName, age, townId);

        PreparedStatement preparedStatement =this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private void hireMinion(int minionId, int villainId) throws SQLException {
        String query = String.format("INSERT INTO minions_villains(minion_id, villain_id) VALUES(%d, %d)",minionId, villainId);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();

    }


}