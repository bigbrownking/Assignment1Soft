package com.alisher.entity.library;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String date;
    private int count;
    public Book(int bookId, String bookName, String author, String date, int count) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.date = date;
        this.count = count;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
