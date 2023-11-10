package com.alisher.entity.people;

import com.alisher.entity.library.Book;
import com.alisher.entity.subjects.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Teacher extends Person implements Observed{
    private Subject subject;
    private NotificationManager manager;
    private String emergencyMessage;

    public Set<Observer> getStudents() {
        return manager.getObservers();
    }
    public Teacher(int id, String name, String surname, Subject subject, boolean debtor){
        super(id, name, surname, debtor);
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

    @Override
    public boolean isDebtor() {
        return super.isDebtor();
    }

    @Override
    public void setDebtor(boolean debtor) {
        super.setDebtor(debtor);
    }

    @Override
    public List<Book> getBooks() {
        return super.getBooks();
    }

    @Override
    public void setBooks(List<Book> books) {
        super.setBooks(books);
    }

    @Override
    public void addBook(Book book) {
        super.addBook(book);
    }

    public NotificationManager getManager() {
        return manager;
    }

    public void setManager(NotificationManager manager) {
        this.manager = manager;
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
        manager.getObservers().add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : manager.getObservers()){
            observer.handleMessage(this.emergencyMessage);
        }
    }
    @Override
    public void removeObserver(Observer observer) {
        manager.getObservers().remove(observer);
    }

    @Override
    public String toString() {
        String studentsList = manager.getObservers().stream()
                .map(observer -> {
                    if(observer instanceof Student){
                        Student student = (Student) observer;
                        return "{id=" + student.getId() + ", name='" + student.getName() + "', surname='" + student.getSurname() + "'}";
                    }
                    else return "unknown person";
                })
                .collect(Collectors.joining(", "));
        return "Teacher{" +
                "subject=" + subject +
                ", students=[" + studentsList + "]" +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", books='" + getBooks() + '\''+
                '}';
    }

}

