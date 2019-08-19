package com.twu.biblioteca;

public class Book extends Product {

    private String title;
    private String bookAuthor;
    private int yearPublished;

    public Book(String title, String bookAuthor, int yearPublished){

        this.title = title;
        this.bookAuthor = bookAuthor;
        this.yearPublished = yearPublished;
    }

    public String getTitle(){
        return title;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String returnInfo(){
        String info = "";

        info += title + "\t|\tBy " + bookAuthor + "\t|\tPublished in " + yearPublished;

        if(isCheckedOut()){
            info += "\t|\tChecked out by: " + getOwner();
        }

        return info;
    }


}
