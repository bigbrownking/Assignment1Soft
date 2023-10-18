package com.alisher.entity.people;

import com.alisher.University;

import java.util.Scanner;

public class Accountant {
    private Rector rector;
    private Student student;
    public Accountant(Rector rector) {
        this.rector = rector;
    }
    public void communicate(String message) {
        student = University.getUniversity().findStudent(new Scanner(System.in));
        rector.receiveMessage(student, message);
    }
}
