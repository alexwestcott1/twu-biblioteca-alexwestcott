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
                library.displayBooks(library.getCheckedInBooks());
            } else {
                System.out.println("No books available!");
            }

        } else if (chosenAction == 3) {

            System.out.println("Quitting application");
            System.exit(0);

        } else if (chosenAction == 1) {
            if(library.displayBooksToCheckOut()) {
                library.displayBooks(library.getCheckedInBooks());

                String chosenBook = sc.next();

                if (verifyListChoice(chosenBook, library.getCheckedInBooks().size())) {
                    library.checkOutBook(Integer.parseInt(chosenBook));
                }
            } else {
                System.out.println("No books available!");
            }


        } else if(chosenAction == 2){

            if(library.displayBooksToCheckIn()) {
                library.displayBooks(library.getCheckedOutBooks());

                int chosenBook = -1;

                String checkInBookChoice = sc.next();

                if (verifyListChoice(checkInBookChoice, library.getCheckedOutBooks().size())) {
                    library.checkInBook(Integer.parseInt(checkInBookChoice));
                }
            }

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




}
