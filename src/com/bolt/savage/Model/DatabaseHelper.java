package com.bolt.savage.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    private static String URL = "jdbc:mysql://localhost/";
    private static String USER = "root";
    private static String PASSWORD = "";

    private static Connection CONNECTION;

    public static Connection getConnectionInstance() {
        if (CONNECTION == null) {
            try {
                setConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return CONNECTION;
    }

    private  static void setConnection() throws SQLException {
        CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
