package com.alisher.entity.library;

import com.alisher.University;
import com.alisher.entity.people.Student;

import java.util.Optional;

public class LocalLibrary implements UniversityLibrarySystem{
    private LibraryManagementAdapter libraryManagementAdapter;

    public LocalLibrary(ExternalLibrary libraryManagementAdapter) {
        this.libraryManagementAdapter = new LibraryManagementAdapter(libraryManagementAdapter);
    }
    @Override
    public void borrowBook(int studentID, Book book) {
        if(checkoutBook(studentID)) {
            System.out.println("Borrowing book '" + book.getBookName() + "' for student ID: " + studentID);
            book.setCount(book.getCount()-1);
            Optional<Student> student = University.getUniversity().getStudents().stream()
                    .filter(x -> x.getId() == studentID)
                    .findFirst();
            Student student1 = student.get();
            student1.addBook(book);
        }
        else System.out.println("You are debtor, go out");
    }
    private boolean checkoutBook(int studentID) {
        Optional<Student> stud = University.getUniversity().getStudents().stream()
                .filter(x -> x.getId() == studentID)
                .findFirst();
        if(stud.isPresent()) {
            Student student = stud.get();
            if(student.isDebtor()) return false;
            return true;
        }
        return false;
    }
    public void deliverBook(int studId, Book book){
        libraryManagementAdapter.borrowBook(studId, book);
    }
}
