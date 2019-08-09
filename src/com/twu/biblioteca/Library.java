package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    //ArrayList that contains all titles

    private ArrayList<Book> checkedInBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public void setupLibrary() {



        checkedInBooks.add(new Book("To Kill A Mockingbird", "Harper Lee", 1960));
        checkedInBooks.add(new Book("Harry Potter", "JK Rowling", 2002));
        checkedInBooks.add(new Book("The Hobbit", "JRR Tolkien", 1937));



    }

    public ArrayList<Book> getCheckedInBooks(){

        return checkedInBooks;

    }

    public ArrayList<Book> getCheckedOutBooks(){

        return checkedOutBooks;

    }





    public boolean displayBooksToCheckIn(){

        if(getCheckedOutBooks().size() > 0){
            return true;
        }

        return false;

    }

    public boolean displayBooksToCheckOut(){

        if(getCheckedInBooks().size() > 0){
            return true;
        }

        return false;

    }


    public boolean checkOutBook(Book book){

        if (!book.isCheckedOut()) {
            getCheckedInBooks().remove(book);
            getCheckedOutBooks().add(book);
            book.setCheckedOut(true);
            return true;
        }

        return false;

    }

    public boolean checkInBook(Book book){



        if (book.isCheckedOut()) {
            getCheckedOutBooks().remove(book);
            getCheckedInBooks().add(book);
            book.setCheckedOut(false);
            return true;
        }

        return false;

    }




}
