package com.alisher.entity;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private Subject subject;
    private List<String> groupList = new ArrayList<>();
    public Teacher() {
    }
    public Teacher(int id, String name, String surname, Subject subject){
        super(id, name, surname);
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

