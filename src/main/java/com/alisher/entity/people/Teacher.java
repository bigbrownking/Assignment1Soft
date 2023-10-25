package com.alisher.entity.people;

import com.alisher.entity.subjects.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person implements Observed{
    private Subject subject;
    private List<Observer> students = new ArrayList<>();
    private String emergencyMessage;

    public List<Observer> getStudents() {
        return students;
    }

    public void setStudents(List<Observer> students) {
        this.students = students;
    }

    public String getEmergencyMessage() {
        return emergencyMessage;
    }

    public void setEmergencyMessage(String emergencyMessage) {
        this.emergencyMessage = emergencyMessage;
    }

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
    @Override
    public String toString() {
        return "Teacher{" +
                "subject=" + subject +
                ", students=" + students +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
    public void sendMessage(Scanner scanner){
        System.out.println("Enter your message");
        scanner.nextLine();
        String message = scanner.nextLine();
        this.emergencyMessage = message;
        notifyObservers();
    }
    @Override
    public void addObserver(Observer observer) {
        students.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        students.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : students){
            observer.handleMessage(this.emergencyMessage);
        }
    }
}

