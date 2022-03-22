package com.onlineauction.onlineauctionservlet.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static void main(String[] args) {
        getConnectionId();
    }

    public static Connection getConnectionId() {

        Connection con = null;

        try {

            DriverManager.registerDriver(new org.postgresql.Driver());
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }
}
