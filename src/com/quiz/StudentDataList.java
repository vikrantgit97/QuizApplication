package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StudentDataList {
    public void getStudentDataList() throws ClassNotFoundException, SQLException {
        ConnectionDetail connectionDetail = new ConnectionDetail();
        Connection con = connectionDetail.getConnectionDetails();
        PreparedStatement ps = con.prepareStatement("select * from studentdata");
        ResultSet rSet = ps.executeQuery();

        Map<Integer, String> map = new HashMap<Integer, String>();//map for get list of student id sorted

        System.out.println("Format of list: studentid=studentname marks");
        while (rSet.next()) {                                    //retrieve data from table studentdata
//			   System.out.print(" student id : "+rSet.getInt(1));
//			   System.out.print(" student name: "+rSet.getString(2));
//			   System.out.print(" marks: "+rSet.getInt(3)+" out of 10");
            map.put(rSet.getInt(1), rSet.getString(2) + " " + rSet.getInt(3));
        }
        System.out.println(map);
    }
}
