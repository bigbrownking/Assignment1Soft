package com.alisher;

import com.alisher.entity.*;
import com.alisher.entity.Math;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class University {

    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();
    private static University university = new University();
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

    public void showStudents(){
        students.stream().forEach(System.out::println);
    }
    public void showTeachers(){
        teachers.stream().forEach(System.out::println);
    }
    public void showSubjects(){
        subjects.stream().forEach(System.out::println);
    }
    public void addStudent(Student student) {
        students.add(student);
    }
}
