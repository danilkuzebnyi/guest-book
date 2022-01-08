package task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    protected static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/onlineShop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "541717danya";

    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
