package com.alisher;

import com.alisher.entity.data.*;
import com.alisher.entity.people.Student;
import com.alisher.entity.people.Teacher;
import com.alisher.entity.subjects.Math;
import com.alisher.entity.subjects.History;
import com.alisher.entity.subjects.Programming;
import com.alisher.entity.subjects.Subject;

import java.util.*;

public class University {

    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();
    private static int globalId = 5;
    private static University university;

    private University() {
        Student student1 = new Student(1, "Alisher", "Khairullin", "SE-2207");
        Student student2 = new Student(2, "Shakhnur", "Aubakirov", "CS-2208");
        Student student3 = new Student(3, "Rayimbek", "Bokhorov", "SE-2209");

        student1.putGrade(Math.getMath(), 100);
        student1.putGrade(History.getHistory(), 89);

        student2.putGrade(Programming.getProgramming(),90);
        student2.putGrade(Math.getMath(),100);

        student3.putGrade(Programming.getProgramming(), 60);
        student3.putGrade(Math.getMath(), 78);
        student3.putGrade(History.getHistory(), 70);


        students.add(student1);
        students.add(student2);
        students.add(student3);

        Teacher teacher1 = new Teacher(4, "Sayat", "Kalnazar", Programming.getProgramming());

        teachers.add(teacher1);

        subjects.add(Math.getMath());
        subjects.add(History.getHistory());
        subjects.add(Programming.getProgramming());
    }

    public static University getUniversity() {
        university = new University();
        return university;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void showStudents() {
        students.stream().forEach(System.out::println);
    }

    public void showTeachers() {
        teachers.stream().forEach(System.out::println);
    }

    public void showSubjects() {
        subjects.stream().forEach(System.out::println);
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter group");
        String group = scanner.next();
        Student student = new Student(globalId++, name, surname, group);
        students.add(student);
        System.out.println("Added");
    }

    public void addSubjectToStudent(Scanner scanner) {
        System.out.println("We have 3 subjects: Math, History, Programming");
        String ans = scanner.next();
        Subject subject;
        if (ans.equalsIgnoreCase("Math")) subject = Math.getMath();
        else if (ans.equalsIgnoreCase("History")) subject = History.getHistory();
        else if (ans.equalsIgnoreCase("Programming")) subject = Programming.getProgramming();
        else {
            System.out.println("Invalid input");
            return;
        }
        Student stud = findStudent(scanner);
        if (stud != null) {
            Random rd = new Random();
            stud.putGrade(subject, rd.nextInt(1, 100));
            System.out.println("Added");
        } else System.out.println("We don't have this student");
    }
    public void additionalInfoAboutStudent(Scanner sc) {
        Student stud = findStudent(sc);
        if (stud != null) {
            Data data;
            boolean SE = false;
            boolean scholarship = false;
            if(stud.getGroup().contains("SE")) SE = true;
            if(stud.getGPA() >= 3.0) scholarship = true;

            if(SE && scholarship) data = new SEstudent(new ScholarshipStudent(new StudentData()));
            else if(!SE && scholarship) data = new CSstudent(new ScholarshipStudent(new StudentData()));
            else if(SE && !scholarship) data = new SEstudent(new WithoutScholarshipStudent(new StudentData()));
            else data = new CSstudent(new WithoutScholarshipStudent(new StudentData()));

            System.out.println(data.showData());
        } else System.out.println("We don't have this student");
    }

    private Student findStudent(Scanner scanner) {
        System.out.println("Which student? (id)");
        int studId = scanner.nextInt();
        Optional<Student> studentOptional = university.getStudents().stream()
                .filter(x -> x.getId() == studId)
                .findFirst();
        if (studentOptional.isPresent()) return studentOptional.get();
        else return null;
    }
}
