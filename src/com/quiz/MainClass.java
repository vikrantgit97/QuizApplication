package com.quiz;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        try {
            System.out.println("                     * WELCOME TO GENERAL KNOWLEDGE QUIZ *                   ");

            CreateTableMcqs.getCreateTableMcqs();
            InsertQuestions.getInsertQuestions();
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
                }

                if (press == 6) {
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