package com.quiz;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("                     * WELCOME TO GENERAL KNOWLEDGE QUIZ *                   ");

        try {

            CreateTableMcqs.getCreateTableMcqs();
            InsertQuestions.getInsertQuestions();

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
            scanner.close();
            e.printStackTrace();
        }
    }
}