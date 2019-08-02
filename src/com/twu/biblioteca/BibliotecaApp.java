package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");

        //ArrayList that contains all titles

        ArrayList<Book> bookList = new ArrayList<Book>();
        Scanner sc = new Scanner(System.in);

        bookList.add(new Book("To Kill A Mockingbird", "Harper Lee", 1960));
        bookList.add(new Book("Harry Potter","JK Rowling", 2002));
        bookList.add(new Book("The Hobbit","JRR Tolkien", 1937));


        while(true) {
            System.out.println("Choose an option by entering the corresponding number:");
            System.out.println("0: List of books");
            System.out.println("-1: Quit application");

            //Program reads input from user, if it is valid, display the corresponding option
            //If input is not valid, display an error message

            String optionSelected = sc.next();

            if (optionSelected.equals("0")) {

                //Display titles from bookList

                System.out.println("Available titles: ");
                for (Book book : bookList) {
                    System.out.println(book.getBookTitle() + "\t|\tBy " + book.getBookAuthor() + "\t|\tPublished in " + book.getYearPublished());
                }

            } else if(optionSelected.equals("-1")){

                System.out.println("Quitting application");
                System.exit(0);

            } else {

                System.out.println("Please select a valid option!");
            }

            System.out.println();
        }

    }
}
