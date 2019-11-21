package ua.antibyte.database;

import java.sql.*;

public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/uatable_db?serverTimezone=UTC";
    private static final String NAME = "root";
    private static final String PASSWORD = "Root1234";

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            System.out.println("[message DB] Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from users");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("user_mobile_number"));
            System.out.println(resultSet.getString("user_password"));
        }
    }
}
