package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/assurance_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // prevent instantiation of this class
    private Database() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
