package com.alisher.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Student extends Person{
    private int course = 1;
    private List<Subject> subjectList = new ArrayList<>();
    private String group;
    private HashMap<Subject, Integer> grades = new HashMap<>();
    public Student(int id, String name, String surname, String group){
        super(id, name, surname);
        this.group = group;
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
    public List<Subject> getSubjectList() {
        return subjectList;
    }
    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public void addSubject(Subject subject){
        subjectList.add(subject);
    }
    public double getGPA() {
        double totalPoints = subjectList.stream()
                .mapToDouble(subject -> {
                    int subjectGrade = grades.getOrDefault(subject, 0);
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
        int totalCredits = subjectList.stream()
                .mapToInt(Subject::getCredit)
                .sum();
        if (totalCredits == 0) return 0;
        return totalPoints / totalCredits;
    }
    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", subjectList=" + subjectList +
                ", group='" + group + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
