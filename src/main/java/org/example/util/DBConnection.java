package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/feirão";
    private static final String USER = "root";
    private static final String PASSWORD = "gabrieli123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/feirão", "root", "gabrieli123");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

