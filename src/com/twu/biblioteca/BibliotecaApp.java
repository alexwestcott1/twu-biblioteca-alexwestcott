package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");

        //ArrayList that contains all titles

        ArrayList<Book> bookList = new ArrayList<Book>();

        bookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1960));
        bookList.add(new Book("Harry Potter","JK Rowling", 2002));
        bookList.add(new Book("The Hobbit","JRR Tolkien", 1937));

        System.out.println("Available titles: ");
        for (Book book : bookList){
            System.out.println(book.getBookTitle() + "\t|\tBy " + book.getBookAuthor() + "\t|\tPublished in " + book.getYearPublished());
        }

    }
}
