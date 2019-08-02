package com.twu.biblioteca;

public class Book {

    private String bookTitle;
    private String bookAuthor;
    private int yearPublished;

    public Book(String bookTitle, String bookAuthor, int yearPublished){

        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearPublished = yearPublished;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
