package com.library.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final String sqlUrl = "jdbc:mysql://localhost:3306/library";
    private static final String sqlUsername = "root";
    private static final String sqlPassword = "Mysql@1234";

    public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
    }
}
