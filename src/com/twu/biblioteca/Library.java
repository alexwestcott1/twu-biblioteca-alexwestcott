package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {


    public void setupLibrary() {

        System.out.println("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");

        //ArrayList that contains all titles

        ArrayList<Book> checkedInBooks = new ArrayList<Book>();
        ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
        Scanner sc = new Scanner(System.in);

        checkedInBooks.add(new Book("To Kill A Mockingbird", "Harper Lee", 1960));
        checkedInBooks.add(new Book("Harry Potter", "JK Rowling", 2002));
        checkedInBooks.add(new Book("The Hobbit", "JRR Tolkien", 1937));


        while (true) {
            System.out.println("Choose an option by entering the corresponding number:");
            System.out.println("0: List of books");
            System.out.println("1: Check out a book");
            System.out.println("-1: Quit application");

            //Program reads input from user, if it is valid, display the corresponding option
            //If input is not valid, display an error message

            String optionSelected = sc.next();

            if (optionSelected.equals("0")) {

                System.out.println("Available titles: ");
                displayBooks(checkedInBooks);

            } else if (optionSelected.equals("-1")) {

                System.out.println("Quitting application");
                System.exit(0);

            } else if (optionSelected.equals("1")) {
                System.out.println("Please choose a book to check out by entering the corresponding number:");
                displayBooks(checkedInBooks);
                System.out.println("-1: Quit to main menu");

                int chosenBook = -1;

                try {
                    chosenBook = sc.nextInt();

                    if(chosenBook < checkedInBooks.size() && chosenBook >= 0) {
                        if (!checkedInBooks.get(chosenBook).isCheckedOut()) {
                            checkOutBook(checkedInBooks, checkedOutBooks, checkedInBooks.get(chosenBook));
                        } else {
                            System.out.println("Sorry, that book is not available");
                        }
                    } else if(chosenBook == -1){
                        System.out.println("Returning to main menu");
                    } else {
                        System.out.println("Please select a valid option!");
                    }
                } catch(InputMismatchException e){
                    System.out.println("Error: incorrect input type entered");
                }


            } else {

                System.out.println("Please select a valid option!");
            }

            System.out.println();
        }
    }



    private void displayBooks(ArrayList<Book> bookList){

        //Display titles from checked in book list
        int count = 0;

        for (Book book : bookList) {
            if(!book.isCheckedOut()) {
                System.out.println(count + ": " + book.getBookTitle() + "\t|\tBy " + book.getBookAuthor() + "\t|\tPublished in " + book.getYearPublished());
                count++;
            }
        }

    }

    private void checkOutBook(ArrayList<Book> checkedIn, ArrayList<Book> checkedOut, Book book){

        checkedIn.remove(book);
        checkedOut.add(book);
        book.setCheckedOut(true);
        System.out.println("Successfully checked out book: " + book.getBookTitle());


    }



}
