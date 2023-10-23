package com.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetail {
    public static Connection getConnectionDetails() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");//load the driver to establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz",
                "root",
                "root"
        );
        return con;
    }
}
