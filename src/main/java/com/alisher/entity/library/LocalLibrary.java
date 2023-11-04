package com.alisher.entity.library;

import com.alisher.University;
import com.alisher.entity.people.Person;
import com.alisher.entity.people.Student;

import java.util.Optional;
import java.util.stream.Stream;

public class LocalLibrary implements UniversityLibrarySystem{
    private LibraryManagementAdapter libraryManagementAdapter;

    public LocalLibrary(ExternalLibrary externalLibrary) {
        this.libraryManagementAdapter = new LibraryManagementAdapter(externalLibrary);
    }
    @Override
    public void borrowBook(int personID, Book book) {
        if(checkoutBook(personID)) {
            System.out.println("Borrowing book '" + book.getBookName() + "' for person ID: " + personID);
            book.setCount(book.getCount()-1);
            Optional<? extends Person> person = Stream.concat(
                            University.getUniversity().getStudents().stream(),
                            University.getUniversity().getTeachers().stream())
                    .filter(p -> p.getId() == personID)
                    .findFirst();
            Person borrower = person.get();
            borrower.addBook(book);
        }
    }
    private boolean checkoutBook(int personID) {
        Optional<? extends Person> person = Stream.concat(
                        University.getUniversity().getStudents().stream(),
                        University.getUniversity().getTeachers().stream())
                .filter(p -> p.getId() == personID)
                .findFirst();
        if(person.isPresent()) {
            Person present = person.get();
            if(present.isDebtor()) {
                System.out.println("You are a debtor, so you can't borrow books.");
                return false;
            }
            return true;
        } else {
            System.out.println("Person with ID " + personID + " was not found.");
            return false;
        }
    }

    public void deliverBook(int studId, Book book){
        libraryManagementAdapter.borrowBook(studId, book);
    }
}
