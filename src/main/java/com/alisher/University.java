package com.alisher;

import com.alisher.entity.*;
import com.alisher.entity.Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class University {

    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int globalId = 5;
    private static University university;
    private University(){
        students.add(new Student(1,"Alisher","Khairullin", "SE-2207"));
        students.add(new Student(2, "Shakhnur", "Aubakirov","SE-2208"));
        students.add(new Student(3, "Rayimbek", "Bokhorov","SE-2209"));

        teachers.add(new Teacher(4, "Sayat", "Kalnazar", Programming.getProgramming()));
        subjects.add(Math.getMath());
        subjects.add(History.getHistory());
        subjects.add(Programming.getProgramming());
    }
    public static University getUniversity(){
        university = new University();
        return university;
    }
    public List<Student> getStudents() {
        return students;
    }
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public static List<Subject> getSubjects() {
        return subjects;
    }
    public static Scanner getScanner(){
        return scanner;
    }

    public void showStudents(){
        students.stream().forEach(System.out::println);
    }
    public void showTeachers(){
        teachers.stream().forEach(System.out::println);
    }
    public void showSubjects(){
        subjects.stream().forEach(System.out::println);
    }
    public void addStudent() {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter group");
        String group = scanner.next();
        Student student = new Student(globalId++,name,surname,group);
        students.add(student);
        System.out.println("Added");
    }
    public static void addSubject(){
        System.out.println("We have 3 subjects: Math, History, Programming");
        String ans = scanner.next();
        Subject subject;
        if(ans.equals("Math")) subject = Math.getMath();
        else if(ans.equals("History")) subject = History.getHistory();
        else if(ans.equals("Programming")) subject = Programming.getProgramming();
        else {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Which student? (id)");
        int studId = scanner.nextInt();
        Optional<Student> studentOptional = university.getStudents().stream()
                .filter(x -> x.getId() == studId)
                .findFirst();
        if(studentOptional.isPresent()){
            Student stud = studentOptional.get();
            stud.addSubject(subject);
            System.out.println("Added");
        }
        else System.out.println("We don't have this student");
    }
}
