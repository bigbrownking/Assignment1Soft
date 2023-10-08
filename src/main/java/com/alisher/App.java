package com.alisher;

import com.alisher.entity.*;
import com.alisher.entity.Math;

import java.util.Optional;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static University university = University.getUniversity();
    private static int globalId = 5;
    public static void main(String[] args){
        System.out.println("Welcome to our university! Who are you?(teacher or student)");
        String answer = sc.next();
        boolean accessibility = answer.equals("teacher") ? true : false;
        while(true){
            System.out.println("What do you want?");
            printMenu();
            if(accessibility){
                System.out.println("PRESS [3] TO ADD STUDENT");
                System.out.println("PRESS [4] TO ADD SUBJECT TO STUDENT BY ID");
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
                    addStudent();
                    System.out.println("Added");
                    break;
                case 4:
                    addSubject();
                    System.out.println("Added");
                    break;

            }
        }
    }
    private static void printMenu(){
        System.out.println("PRESS [0] TO EXIT");
        System.out.println("PRESS [1] TO SHOW STUDENT LIST");
        System.out.println("PRESS [2] TO SHOW TEACHER LIST");
    }
    private static void addStudent(){
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter surname");
        String surname = sc.next();
        System.out.println("Enter group");
        String group = sc.next();
        Student student = new Student(globalId++,name,surname,group);
        university.addStudent(student);
    }
    private static void addSubject(){
        System.out.println("We have 3 subjects: Math, History, Programming");
        String ans = sc.next();
        Subject subject = null;
        if(ans.equals("Math"))
            subject = Math.getMath();
        else if(ans.equals("History"))
            subject = History.getHistory();
        else if(ans.equals("Programming"))
            subject = Programming.getProgramming();
        else {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Which student?");
        university.showStudents();
        int studId = sc.nextInt();
        Optional<Student> studentOptional = university.getStudents().stream().filter(x -> x.getId() == studId).findFirst();
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.addSubject(subject);
        }

    }
}
