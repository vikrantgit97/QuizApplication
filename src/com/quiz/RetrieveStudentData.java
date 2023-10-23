package com.quiz;

import com.exception.InvalidInputException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetrieveStudentData {

    public void getRetrieveStudentData() {
        try {
            Connection con = ConnectionDetail.getConnectionDetails();
            PreparedStatement preparedStatement = con.prepareStatement("select * from student_data");
            ResultSet rSet = preparedStatement.executeQuery();
            con.close();
            preparedStatement.close();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter StudentId to get score information: ");
            int id = sc.nextInt();
            while (rSet.next()) {
                if (id == rSet.getInt(1)) {
                    System.out.print("StudentName: " + rSet.getString(2) + " Marks: " + rSet.getInt(3));
                } else {
                    rSet.close();
                    throw new InvalidInputException("Invalid input enter only eg. 2 ");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}