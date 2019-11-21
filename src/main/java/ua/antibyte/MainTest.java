package ua.antibyte;

import ua.antibyte.database.DbConnection;

import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) {
        DbConnection db = new DbConnection();

        try {
            db.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
