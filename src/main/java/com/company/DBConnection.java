package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        // ensure driver registered (safe)
        Class.forName("com.mysql.cj.jdbc.Driver");
        // add timezone and disable SSL if you don't use it
        String url = "jdbc:mysql://localhost:3306/payroll_db?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "123456789@Shu";
        return DriverManager.getConnection(url, user, password);
    }
}