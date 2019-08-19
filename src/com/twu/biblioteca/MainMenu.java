package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {


    private Library library;
    private Scanner sc = new Scanner(System.in);
    private String loggedInUser = "";

    public MainMenu(Library lib){

        library = lib;
        System.out.println("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!!");

    }

    public void runApplication(){

        while(true){

            displayMenu();
            String optionSelected = sc.next();
            chooseOption(optionSelected);

        }

    }

    private void displayMenu(){

            System.out.println("Choose an option by entering the corresponding number:");
            System.out.println("0: List of books");
            System.out.println("1: List of films");
            System.out.println("2: Check out a book");
            System.out.println("3: Check in a book");
            System.out.println("4: Check out a film");
            System.out.println("5: Check in a film");
            System.out.println("6: Quit application");

    }

    private void chooseOption(String option){

        //Program reads input from user, if it is valid, display the corresponding option
        //If input is not valid, display an error message

        if(option.matches("[0-3]")){
            performAction(Integer.parseInt(option));
        } else {
            System.out.println("Please select a valid option!");
        }

    }

    public void performAction(int chosenAction){
        if (chosenAction == 0) {

            if(library.getCheckedInBooks().size() > 0) {
                System.out.println("Available titles: ");
                displayBooks(library.getCheckedInBooks());
            } else {
                System.out.println("No books available!");
            }

        } else if(chosenAction == 1){

            if(library.getCheckedInFilms().size() > 0) {
                System.out.println("Available titles: ");
                displayBooks(library.getCheckedInFilms());
            } else {
                System.out.println("No films available!");
            }

        } else if (chosenAction == 6) {

            System.out.println("Quitting application");
            System.exit(0);

        } else if (chosenAction == 2) {
            if(library.displayBooksToCheckOut()) {

                System.out.println("Please choose a book to check out by entering the corresponding number:");

                displayBooks(library.getCheckedInBooks());

                String checkOutBookChoice = sc.next();

                if (verifyListChoice(checkOutBookChoice, library.getCheckedInBooks().size())) {

                    Product book = library.getCheckedInBooks().get(Integer.parseInt(checkOutBookChoice));

                    if(enterLoginDetails()) {
                        if (library.checkOutProduct(book, loggedInUser, false)) {
                            System.out.println("Successfully checked out book: " + book.getTitle());
                            loggedInUser = "";
                        } else {
                            System.out.println("Sorry, that book is not available");
                        }
                    }
                }
            } else {
                System.out.println("No books available!");
            }


        } else if(chosenAction == 3){

            if(library.displayBooksToCheckIn()) {

                System.out.println("Please choose a book to check in by entering the corresponding number:");
                displayBooks(library.getCheckedOutBooks());


                String checkInBookChoice = sc.next();

                if (verifyListChoice(checkInBookChoice, library.getCheckedOutBooks().size())) {

                    Product book = library.getCheckedOutBooks().get(Integer.parseInt(checkInBookChoice));

                    if(enterLoginDetails()) {
                        if (library.checkInProduct(book, false)) {
                            System.out.println("Thank you for returning the book: " + book.getTitle());
                        } else {
                            System.out.println("Sorry, that book is not available");
                        }
                    }
                }
            } else {
                System.out.println("No books available!");
            }

        } else if(chosenAction == 4){

        } else if(chosenAction == 5){

        }

        System.out.println();
    }

    public boolean verifyListChoice(String option, int listSize){

        if(option.matches("[0-" + (listSize - 1) + "]")){
            return true;
        } else {
            System.out.println("Please select a valid option!");
        }

        return false;

    }

    public void displayBooks(ArrayList<Product> bookList){

        //Display titles from book list
        int count = 0;

        for (Product book : bookList) {

            System.out.print(count + ": ");
            System.out.print(book.returnInfo());

            System.out.println();

            count++;
        }

    }

    public boolean enterLoginDetails(){

        boolean detailsValid = false;
        String libraryNumber;
        String password;

        System.out.println("Enter library number:");

        libraryNumber = sc.next();

        System.out.println("Enter password:");

        password = sc.next();

        detailsValid = library.validateLogin(libraryNumber, password);

        if(!detailsValid){
            System.out.println("Details not valid!");
        } else {
            loggedInUser = libraryNumber;
        }

        return detailsValid;

    }


}
