package com.alisher;

import java.util.Scanner;

public class App {
    private static University university = University.getUniversity();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Welcome to our university! Who are you?(teacher or student)");
        String answer = sc.next();
        boolean accessibility = answer.equals("teacher") ? true : false;
        while(true){
            System.out.println("What do you want?");
            System.out.println("PRESS [0] TO EXIT");
            System.out.println("PRESS [1] TO SHOW STUDENT LIST");
            System.out.println("PRESS [2] TO SHOW TEACHER LIST");
            System.out.println("PRESS [3] TO WRITE MESSAGE TO RECTOR");
            if(accessibility){
                System.out.println("PRESS [4] GIVE ADDITIONAL INFO");
                System.out.println("PRESS [5] TO ADD STUDENT");
                System.out.println("PRESS [6] TO ADD SUBJECT TO STUDENT BY ID");
            }
            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Good bye!");
                    System.exit(1);
                case 1:
                    university.showStudents();
                    break;
                case 2:
                    university.showTeachers();
                    break;
                case 3:
                    university.allowStudentToSendMessage(sc);
                    break;
                case 4:
                    university.additionalInfoAboutStudent(sc);
                    break;
                case 5:
                   university.addStudent(sc);
                    break;
                case 6:
                    university.addSubjectToStudent(sc);
                    break;
            }
        }
    }
}