package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Database instance = null;
    private String url = "jdbc:mysql://localhost:3306/assurance_db";
    private String username = "root";
    private String password = "password";

    private Database() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established..");
        } catch (SQLException e) {
            System.out.println("Connection not established, " + e.getMessage());
        }
    }

    public static Database getConnection() {
        if(instance == null) instance = new Database();
        return instance;
    }
}
