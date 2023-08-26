package com.quiz;

import com.exception.InvalidInputException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetrieveStudentData {

    public void getRetrieveStudentData() {
        ConnectionDetail c = new ConnectionDetail();
        try {
            Connection con = c.getConnectionDetails();
            PreparedStatement ps = con.prepareStatement("select * from studentdata");
            ResultSet rSet = ps.executeQuery();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter StudentId to get score information: ");
            int id = sc.nextInt();
            while (rSet.next()) {
                if (id == rSet.getInt(1)) {
                    System.out.print("StudedntName: " + rSet.getString(2) + " Marks: " + rSet.getInt(3));
                } else {
                    throw new InvalidInputException("Invalid input enter only eg. 2 ");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}