package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QuizData {

    public void getQuizData() throws SQLException, ClassNotFoundException {
        final int TotalMarks = 10;

        ConnectionDetail c = new ConnectionDetail();
        Connection con = c.getConnectionDetails();

        Scanner sc = new Scanner(System.in);

        System.out.print("\nENTER STUDENT NAME: ");
        String StudentName = sc.next();

        RandomQuestions r = new RandomQuestions();
        r.getRandomQuestions();

        PreparedStatement ps1 = con.prepareStatement("insert into studentdata"
                + "(StudentName,Marks,TotalMarks)values(?,?,?)");

        ps1.setString(1, StudentName);
        ps1.setInt(3, TotalMarks);

        CountMarks count = new CountMarks();
        int Marks = (count.getMarks() - 1);
        ps1.setInt(2, Marks);
        ps1.executeUpdate();
        System.out.print("\nYour score is: " + Marks + " out of 10");

        if (Marks == 8 || Marks == 9 || Marks == 10) {
            System.out.print(" Class A\n");
        } else if (Marks == 6 || Marks == 7 || Marks == 8) {
            System.out.print(" Class B\n");
        } else if (Marks == 5) {
            System.out.print(" Class C\n");
        } else {
            System.out.print(" Fail\n");
        }
    }

    public static class MainClass {
        public static void main(String[] args) {
            try {
                System.out.println("                     * WELCOME TO GENERAL KNOWLEDGE QUIZ *                   ");
                ConnectionDetail c = new ConnectionDetail();
                Connection con = c.getConnectionDetails();
                CreateTableMcqs.getCreateTableMcqs();
                InsertQuestions questions = new InsertQuestions();
                String sql = questions.getInsertQuestions();
                Statement statement = con.createStatement();
                statement.execute(sql);
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("\nPress 5 to START QUIZ or Press 6 to retrieve student`s data using StudentId: ");
                    int press = scanner.nextInt();
                    if (press == 5) {

                        QuizData studentData = new QuizData();
                        studentData.getQuizData();
                        StudentDataList studentDataList = new StudentDataList();
                        studentDataList.getStudentDataList();
                        RetrieveStudentData retrieveStudentData = new RetrieveStudentData();
                        retrieveStudentData.getRetrieveStudentData();
                        break;

                    } else if (press == 6) {
                        RetrieveStudentData retrieveStudentData = new RetrieveStudentData();
                        retrieveStudentData.getRetrieveStudentData();
                    } else {
                        System.out.println("Invalid Input please Enter 5 or 6");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
	