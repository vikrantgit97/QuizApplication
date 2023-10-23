package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDataList {
    public void getStudentDataList() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionDetail.getConnectionDetails();
        PreparedStatement preparedStatement = con.prepareStatement("select * from student_data");
        ResultSet resultSet = preparedStatement.executeQuery();
        con.close();
        preparedStatement.close();
        while (resultSet.next()) {                                    //retrieve data from table studentdata
            System.out.print("\nStudentId: "+resultSet.getInt(1)
                    + "\nStudentName: " + resultSet.getString(2)
                    + "\n Marks: " + resultSet.getInt(3)
                    + " out of 10");

        }
        resultSet.close();
    }
}