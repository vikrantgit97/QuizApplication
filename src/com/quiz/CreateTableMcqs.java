package com.quiz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableMcqs {
    public static void getCreateTableMcqs() throws SQLException, ClassNotFoundException {
        ConnectionDetail c = new ConnectionDetail();
        Connection con = c.getConnectionDetails();
        String sql = """ 
                create table MCQ(QNos int not null auto_increment, Questions varchar(2000),
                Answers varchar(255),primary key(QNos))
                """;
        Statement st = con.createStatement();
        st.execute(sql);
        //System.out.println("table created sucessfully....");
        st.close();
        con.close();
    }
}
