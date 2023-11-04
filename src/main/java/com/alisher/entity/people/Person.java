package com.alisher.entity.people;

import com.alisher.entity.library.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Person {
    private int id;
    private String name;
    private String surname;
    private boolean isDebtor;
    private List<Book> books = new ArrayList<>();

    public Person(int id, String name, String surname, boolean isDebtor) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isDebtor() {
        return isDebtor;
    }

    public void setDebtor(boolean debtor) {
        isDebtor = debtor;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        Optional<Book> existingBook = getBooks().stream()
                .filter(b -> b.getBookId() == book.getBookId())
                .findFirst();
        if (existingBook.isPresent()) {
            Book foundBook = existingBook.get();
            foundBook.setCount(foundBook.getCount() + 1);
        } else{
            Book cloned = new Book();
            cloned.setBookId(book.getBookId());
            cloned.setBookName(book.getBookName());
            cloned.setCount(1);
            books.add(cloned);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isDebtor=" + isDebtor +
                ", books=" + books +
                '}';
    }
}
