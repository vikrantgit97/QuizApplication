package com.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetail {
    public Connection getConnectionDetails() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");//load the driver to establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz",
                "root", "root");
        return con;
    }
}
