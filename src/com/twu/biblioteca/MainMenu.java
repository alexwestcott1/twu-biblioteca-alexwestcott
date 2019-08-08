package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {


    private Library library;
    private Scanner sc = new Scanner(System.in);

    public MainMenu(Library lib){

        library = lib;
        System.out.println("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!");

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
            System.out.println("1: Check out a book");
            System.out.println("2: Check in a book");
            System.out.println("3: Quit application");



    }

    private void chooseOption(String option){

        if(option.matches("[0-3]")){
            performAction(Integer.parseInt(option));
        } else {
            System.out.println("Please select a valid option!");
        }

        //Program reads input from user, if it is valid, display the corresponding option
        //If input is not valid, display an error message




    }

    private void performAction(int chosenAction){
        if (chosenAction == 0) {

            if(library.getCheckedInBooks().size() > 0) {
                System.out.println("Available titles: ");
                library.displayBooks(library.getCheckedInBooks());
            } else {
                System.out.println("No books available!");
            }

        } else if (chosenAction == 3) {

            System.out.println("Quitting application");
            System.exit(0);

        } else if (chosenAction == 1) {
            if(library.getCheckedInBooks().size() > 0) {
                System.out.println("Please choose a book to check out by entering the corresponding number:");
                library.displayBooks(library.getCheckedInBooks());

                int chosenBook = -1;

                try {
                    chosenBook = sc.nextInt();

                    if (chosenBook < library.getCheckedInBooks().size() && chosenBook >= 0) {
                        if (!library.getCheckedInBooks().get(chosenBook).isCheckedOut()) {
                            library.checkInOutBook(library.getCheckedInBooks(), library.getCheckedOutBooks(), library.getCheckedInBooks().get(chosenBook), false);
                        } else {
                            System.out.println("Sorry, that book is not available");
                        }
                    } else {
                        System.out.println("Please select a valid option!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: incorrect input type entered");
                }
            } else {
                System.out.println("No books available!");
            }


        } else if(chosenAction == 2){

            if(library.getCheckedOutBooks().size() > 0) {
                System.out.println("Please choose a book to check in by entering the corresponding number:");
                library.displayBooks(library.getCheckedOutBooks());

                int chosenBook = -1;

                try {
                    chosenBook = sc.nextInt();

                    if (chosenBook < library.getCheckedOutBooks().size() && chosenBook >= 0) {
                        if (library.getCheckedOutBooks().get(chosenBook).isCheckedOut()) {
                            library.checkInOutBook(library.getCheckedInBooks(), library.getCheckedOutBooks(), library.getCheckedOutBooks().get(chosenBook), true);
                        } else {
                            System.out.println("Sorry, that book is not available");
                        }
                    } else {
                        System.out.println("Please select a valid option!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: incorrect input type entered");
                }
            } else {
                System.out.println("No books available!");
            }

        }

        System.out.println();
    }




}
