package com.alisher.entity.library;

public class LibraryManagementAdapter implements UniversityLibrarySystem {
    private ExternalLibrarySystem externalLibrary;

    public LibraryManagementAdapter(ExternalLibrarySystem externalLibrary) {
        this.externalLibrary = externalLibrary;
    }

    @Override
    public void borrowBook(int studentID, Book book) {
        externalLibrary.deliverBook(studentID, book.getBookName());
    }
}