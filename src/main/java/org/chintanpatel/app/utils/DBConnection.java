package org.chintanpatel.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String USER = "chintanpatel";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DRIVER = "org.postgresql.Driver";


    public static Connection getConnection() {
        Connection connection = DBConnection.getConnection();
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
                if (connection == null) {
                    System.out.println("Cannot connect to database.");
                } else {
                    System.out.println("Connect to database.");
                }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
