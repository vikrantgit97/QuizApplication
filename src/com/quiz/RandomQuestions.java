package com.quiz;

import com.exception.InvalidInputException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RandomQuestions {

    public void getRandomQuestions() throws SQLException, ClassNotFoundException {
        Connection con = ConnectionDetail.getConnectionDetails();
        PreparedStatement preparedStatement = con.prepareStatement("select distinct * from mcq order by rand() limit 10");
        ResultSet resultSet = preparedStatement.executeQuery();
        con.close();
        preparedStatement.close();
        Scanner sc = new Scanner(System.in);
        while (resultSet.next()) {    //retrieve employee data

            System.out.println("\nQ." + resultSet.getString(1)
                    + " " + resultSet.getString(2)
                    + "\nEnter Answer eg. A,B,C,D : ");

            String Answer = sc.next();

            if (Answer.equals("A") || Answer.equals("B") || Answer.equals("C") || Answer.equals("D")) {
                if ((Answer).equals(resultSet.getString(3))) {
                    CountMarks count = new CountMarks();
                    count.getMarks();
                }
            } else {
                resultSet.close();
                sc.close();
                throw new InvalidInputException("InvalidInputException..... enter only eg. A,B,C,D ");
            }
        }
    }
}