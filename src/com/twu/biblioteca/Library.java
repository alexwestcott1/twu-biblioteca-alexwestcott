package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {

    //ArrayList that contains all titles

    ArrayList<Book> checkedInBooks = new ArrayList<Book>();
    ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

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



    public void displayBooks(ArrayList<Book> bookList){

        //Display titles from checked in book list
        int count = 0;

        for (Book book : bookList) {
            System.out.println(count + ": " + book.getBookTitle() + "\t|\tBy " + book.getBookAuthor() + "\t|\tPublished in " + book.getYearPublished());
            count++;
        }

    }

    public boolean displayBooksToCheckIn(){

        if(getCheckedOutBooks().size() > 0){
            System.out.println("Please choose a book to check in by entering the corresponding number:");
            return true;
        }

        System.out.println("No books available!");
        return false;

    }

    public boolean displayBooksToCheckOut(){

        if(getCheckedInBooks().size() > 0){
            System.out.println("Please choose a book to check out by entering the corresponding number:");
            return true;
        }

        System.out.println("No books available!");
        return false;

    }


    public void checkOutBook(int chosenBook){

        Book book = getCheckedInBooks().get(chosenBook);


        if (!book.isCheckedOut()) {
            getCheckedInBooks().remove(book);
            getCheckedOutBooks().add(book);
            System.out.println("Successfully checked out book: " + book.getBookTitle());
            book.setCheckedOut(true);
        } else {
            System.out.println("Sorry, that book is not available");
        }

    }

    public void checkInBook(int chosenBook){

        Book book = getCheckedOutBooks().get(chosenBook);

        System.out.println("Book is by " + book.getBookAuthor());
        if (book.isCheckedOut()) {
            getCheckedOutBooks().remove(book);
            getCheckedInBooks().add(book);
            System.out.println("Thank you for returning the book: " + book.getBookTitle());
            book.setCheckedOut(false);
        } else {
            System.out.println("Sorry, that book is not available");
        }

    }




}
