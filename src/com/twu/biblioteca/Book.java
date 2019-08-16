package com.twu.biblioteca;

public class Book {

    private String bookTitle;
    private String bookAuthor;
    private int yearPublished;
    private String owner = null;

    private boolean checkedOut;

    public Book(String bookTitle, String bookAuthor, int yearPublished){

        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearPublished = yearPublished;
        checkedOut = false;
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

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getOwner(){ return owner; }

    public void setOwner(String owner){ this.owner = owner; }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
