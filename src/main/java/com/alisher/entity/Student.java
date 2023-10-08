package com.alisher.entity;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private int course = 1;
    private List<Subject> subjectList = new ArrayList<>();
    private String group;
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
