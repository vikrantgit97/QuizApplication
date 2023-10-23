package com.quiz;

import com.exception.InvalidInputException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RandomQuestions {

    public void getRandomQuestions() throws SQLException, ClassNotFoundException {
        ConnectionDetail co = new ConnectionDetail();
        Connection con = co.getConnectionDetails();
        PreparedStatement ps = con.prepareStatement("select distinct * from mcq order by rand() limit 10");
        ResultSet resultSet = ps.executeQuery();
        Scanner sc = new Scanner(System.in);
        while (resultSet.next()) {    //retrieve employee data

            System.out.println("\nQ." + resultSet.getString(1) + " " + resultSet.getString(2));
            System.out.print("\nEnter Answer eg. A,B,C,D : ");
            String Answer = sc.next();

            if (Answer.equals("A") || Answer.equals("B") || Answer.equals("C") || Answer.equals("D")) {
                if ((Answer).equals(resultSet.getString(3))) {
                    CountMarks count = new CountMarks();
                    count.getMarks();
                }
            } else {
                throw new InvalidInputException("InvalidInputException..... enter only eg. A,B,C,D ");
            }
        }
    }
}
