package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/usersdb";
    private static final String CONNECTION_USER = "root";
    private static final String CONNECTION_PASSWORD = "password";
    private static Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        CONNECTION_URL,
                        CONNECTION_USER,
                        CONNECTION_PASSWORD
                );
            } catch (SQLException e) {
                throw new RuntimeException("Error during connecting to DB: " + e.getMessage());
            }
        }
        return connection;
    }
}
