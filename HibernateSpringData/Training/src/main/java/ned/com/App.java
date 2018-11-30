package ned.com;

import java.sql.*;
import java.util.Properties;

public class App {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/soft_uni_simple";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM soft_uni_simple.employees";
    public static void main(String[] args) throws SQLException {

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "881223");

        Connection connection = DriverManager.getConnection(CONNECTION_STRING, props);

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);

        ResultSet resultSet = preparedStatement.executeQuery();

       while (resultSet.next()) {
        System.out.println(resultSet.getInt("id"));

       }




    }
}
