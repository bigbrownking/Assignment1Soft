package com.alisher.entity.library;

import com.alisher.University;
import com.alisher.entity.people.Person;

import java.util.Optional;
import java.util.stream.Stream;

public class ExternalLibrary implements ExternalLibrarySystem {
    @Override
    public void deliverBook(int personId, String bookTitle) {
        System.out.println("Book '" + bookTitle + "' has been delivered for student ID: " + personId);
        Optional<? extends Person> person = Stream.concat(
                        University.getUniversity().getStudents().stream(),
                        University.getUniversity().getTeachers().stream())
                .filter(p -> p.getId() == personId)
                .findFirst();
        Person person1 = person.get();
        Book book = new Book();
        book.setBookName(bookTitle);
        book.setCount(5);
        person1.addBook(book);
    }
}
