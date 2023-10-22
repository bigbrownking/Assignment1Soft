package com.alisher.entity.library;

import com.alisher.University;
import com.alisher.entity.people.Student;

import java.util.Optional;

public class ExternalLibrary implements ExternalLibrarySystem {
    @Override
    public void deliverBook(int studentId, String bookTitle) {
        System.out.println("Book '" + bookTitle + "' has been delivered for student ID: " + studentId);
        Optional<Student> student = University.getUniversity().getStudents().stream()
                .filter(x -> x.getId() == studentId)
                .findFirst();
        Student student1 = student.get();
        Book book = new Book();
        book.setBookName(bookTitle);
        student1.addBook(book);
    }
}
