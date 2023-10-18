package com.alisher.entity.people;

import com.alisher.entity.subjects.Subject;

import java.util.*;

public class Student extends Person{
    private int course = 1;
    private String group;
    private HashMap<Subject, Integer> grades = new HashMap<>();
    public Student(int id, String name, String surname, String group){
        super(id, name, surname);
        this.group = group;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    public Student() {
        super();
    }
    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {this.group = group;}

    public HashMap<Subject, Integer> getGrades() {return grades;}
    public void setGrades(HashMap<Subject, Integer> grades) {this.grades = grades;}
    public void putGrade(Subject subject, int grade){
        grades.put(subject, grade);
    }
    public double getGPA() {
        double totalPoints = grades.entrySet().stream()
                .mapToDouble(entry -> {
                    Subject subject = entry.getKey();
                    int subjectGrade = entry.getValue();
                    int subjectCredits = subject.getCredit();

                    if (subjectGrade >= 95) return 4.0 * subjectCredits;
                    else if (subjectGrade >= 90) return 3.61 * subjectCredits;
                    else if (subjectGrade >= 85) return 3.33 * subjectCredits;
                    else if (subjectGrade >= 80) return 3.0 * subjectCredits;
                    else if (subjectGrade >= 75) return 2.67 * subjectCredits;
                    else if (subjectGrade >= 70) return 2.33 * subjectCredits;
                    else if (subjectGrade >= 65) return 2.0 * subjectCredits;
                    else if (subjectGrade >= 60) return 1.67 * subjectCredits;
                    else if (subjectGrade >= 55) return 1.33 * subjectCredits;
                    else if (subjectGrade >= 50) return 1.0 * subjectCredits;
                    else return 0;
                })
                .sum();
        int totalCredits = grades.keySet().stream()
                .mapToInt(Subject::getCredit)
                .sum();
        if (totalCredits == 0) return 0;
        return totalPoints / totalCredits;
    }

    public static String sendMessageToAccountant(Scanner scanner) {
       String message = scanner.nextLine();
       return message;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", grades=" + grades +
                ", group='" + group + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
