package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class QuizData {

    public void getQuizData() throws SQLException, ClassNotFoundException {
        final int TotalMarks = 10;

        Connection con = ConnectionDetail.getConnectionDetails();

        Scanner sc = new Scanner(System.in);

        System.out.print("\nENTER STUDENT NAME: ");
        String StudentName = sc.next();

        RandomQuestions randomQuestions = new RandomQuestions();
        randomQuestions.getRandomQuestions();

        PreparedStatement preparedStatement = con.prepareStatement("insert into student_data"
                + "(StudentName,Marks,TotalMarks)values(?,?,?)");

        preparedStatement.setString(1, StudentName);
        preparedStatement.setInt(3, TotalMarks);

        CountMarks count = new CountMarks();
        int Marks = (count.getMarks() - 1);
        preparedStatement.setInt(2, Marks);
        preparedStatement.executeUpdate();
        con.close();
        preparedStatement.close();
        sc.close();
        System.out.print("\nYour score is: " + Marks + " out of 10");

        if (Marks >= 8 && Marks <= 10) {
            System.out.print(" Class A\n");
        } else if (Marks >= 6 && Marks <= 8) {
            System.out.print(" Class B\n");
        } else if (Marks == 5) {
            System.out.print(" Class C\n");
        } else {
            System.out.print(" Fail\n");
        }
    }
}