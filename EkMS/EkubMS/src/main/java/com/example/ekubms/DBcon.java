package com.example.ekubms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBcon {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/aastuekub";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection con = null;

    public Connection connMethod() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to a selected database...");
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        if (con != null) {
            System.out.println("Connected database successfully...");
        } else {
            System.out.println("nFailed to connect to MYSQL DB");
        }
        return con;
    }
}