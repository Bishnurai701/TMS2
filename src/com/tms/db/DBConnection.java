package com.tms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tms.dao.UserGroupDAO;



public class DBConnection {
        public Connection connection;

    public DBConnection(String jdbcURL, String jdbcUsername, String jdbcPassword) {
    }

    public void createConnection() throws SQLException, ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3309/db_tms?uselegacyDatetimeCode=false&serverTimezone=UTC";
        String jdbcUsername = "admin";
        String jdbcPassword = "admin";
        if (connection == null || connection.isClosed())
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    public void disConnect() throws SQLException {
        if(connection!=null || connection.isClosed())
        {
            connection.close();
        }
    }

}
