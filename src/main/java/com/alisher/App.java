package com.alisher;

public class App {
    private static University university = University.getUniversity();
    public static void main(String[] args){
        System.out.println("Welcome to our university! Who are you?(teacher or student)");
        String answer = University.getScanner().next();
        boolean accessibility = answer.equals("teacher") ? true : false;
        while(true){
            System.out.println("What do you want?");
            System.out.println("PRESS [0] TO EXIT");
            System.out.println("PRESS [1] TO SHOW STUDENT LIST");
            System.out.println("PRESS [2] TO SHOW TEACHER LIST");
            if(accessibility){
                System.out.println("PRESS [3] TO ADD STUDENT");
                System.out.println("PRESS [4] TO ADD SUBJECT TO STUDENT BY ID");
            }
            int choice = University.getScanner().nextInt();
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
                   university.addStudent();
                    break;
                case 4:
                    university.addSubject();
                    break;
            }
        }
    }
}