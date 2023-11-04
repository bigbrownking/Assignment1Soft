package com.alisher.entity.people;

import com.alisher.entity.library.Book;
import com.alisher.entity.subjects.Subject;

import java.util.*;

public class Student extends Person implements Observer{
    private int course = 1;
    private String group;
    private HashMap<Subject, Integer> grades = new HashMap<>();
    private String emergencyMessageFromTeacher="";
    public Student(int id, String name, String surname, String group, Boolean debtor){
        super(id, name, surname, debtor);
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

    public String getEmergencyMessageFromTeacher() {
        return emergencyMessageFromTeacher;
    }

    public void setEmergencyMessageFromTeacher(String emergencyMessageFromTeacher) {
        this.emergencyMessageFromTeacher = emergencyMessageFromTeacher;
    }

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

    @Override
    public void addBook(Book book) {
        super.addBook(book);
    }

    @Override
    public void handleMessage(String message) {
        this.emergencyMessageFromTeacher = message;
        System.out.println("Dear " + getName() +" "+ getSurname() +". We have some changes in syllabus: " + message);
    }
    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", grades=" + grades +
                ", group='" + group + '\'' +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", debtor='" + isDebtor() + '\'' +
                ", books='" + getBooks() + '\'' +
                '}';
    }

}
