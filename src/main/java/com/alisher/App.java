package com.alisher;

import java.util.Scanner;

public class App {
    private static final University university = University.getUniversity();
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Welcome to our university! Who are you?(teacher or student)");
        String answer = sc.next();
        boolean accessibility = answer.equals("teacher");
        for(;;){
            System.out.println("What do you want?");
            System.out.println("PRESS [0] TO EXIT");
            System.out.println("PRESS [1] TO SHOW STUDENT LIST");
            System.out.println("PRESS [2] TO GO TO LIBRARY");
            System.out.println("PRESS [3] TO GO TO CANTEEN");
            if(accessibility){
                System.out.println("PRESS [4] TO SHOW TEACHER LIST");
                System.out.println("PRESS [5] GIVE ADDITIONAL INFO");
                System.out.println("PRESS [6] TO ADD STUDENT");
                System.out.println("PRESS [7] TO PUT GRADE TO STUDENT BY ID");
                System.out.println("PRESS [8] TO NOTIFY STUDENTS");
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 0 -> {
                    System.out.println("Good bye!");
                    System.exit(1);
                }
                case 1 -> university.showStudents();
                case 2 -> university.goToLibrary(sc, accessibility);
                case 3 -> university.goToCanteen(sc, accessibility);
                case 4 -> university.showTeachers();
                case 5 -> university.additionalInfoAboutStudent(sc);
                case 6 -> university.addStudent(sc);
                case 7 -> university.putGradeToStudent(sc);
                case 8 -> university.messageFromTeacher(sc);
            }
        }

    }
}