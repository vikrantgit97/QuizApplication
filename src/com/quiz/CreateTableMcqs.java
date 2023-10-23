package com.quiz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableMcqs {
    public static void getCreateTableMcqs() throws SQLException, ClassNotFoundException {
        Connection con = ConnectionDetail.getConnectionDetails();
        String sql = """ 
                create table MCQ (
                    QNos int not null auto_increment, 
                    Questions varchar(2000),
                    Answers varchar(5),
                    primary key(QNos)
                )
                """;
        String sqlCreate = """
                CREATE TABLE student_data (
                    StudentID INT AUTO_INCREMENT PRIMARY KEY,
                    StudentName VARCHAR(50),
                    Marks INT,
                    TotalMarks INT
                )
                """;
        Statement st = con.createStatement();
        st.execute(sql);
        st.execute(sqlCreate);
        //System.out.println("table created sucessfully....");
        st.close();
        con.close();
    }
}
