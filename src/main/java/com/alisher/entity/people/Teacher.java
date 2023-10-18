package com.alisher.entity.people;

import com.alisher.entity.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private Subject subject;
    private List<String> groupList = new ArrayList<>();
    public Teacher() {
    }
    public Teacher(int id, String name, String surname, Subject subject){
        super(id, name, surname);
        this.subject = subject;
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
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "subject=" + subject +
                ", groupList=" + groupList +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

