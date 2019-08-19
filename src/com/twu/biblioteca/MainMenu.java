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

        if(option.matches("[0-6]")){
            performAction(Integer.parseInt(option));
        } else {
            System.out.println("Please select a valid option!");
        }

    }

    public void performAction(int chosenAction){
        if (chosenAction == 0) {

            if(library.getCheckedInBooks().size() > 0) {
                System.out.println("Available titles: ");
                displayProducts(library.getCheckedInBooks());
            } else {
                System.out.println("No books available!");
            }

        } else if(chosenAction == 1){

            if(library.getCheckedInFilms().size() > 0) {
                System.out.println("Available titles: ");
                displayProducts(library.getCheckedInFilms());
            } else {
                System.out.println("No films available!");
            }

        } else if (chosenAction == 6) {

            System.out.println("Quitting application");
            System.exit(0);

        } else if (chosenAction == 2) {

            chooseProductToCheckOut(false);

        } else if(chosenAction == 3){

            chooseProductToCheckIn(false);

        } else if(chosenAction == 4){

            chooseProductToCheckOut(true);

        } else if(chosenAction == 5){

            chooseProductToCheckIn(true);
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

    private void chooseProductToCheckIn(boolean film){

        int size = 0;

        if(library.displayProductsToCheckIn(film)) {

            System.out.println("Please choose a product to check in by entering the corresponding number:");

            if(film) {
                displayProducts(library.getCheckedOutFilms());
                size = library.getCheckedOutFilms().size();
            } else {
                displayProducts(library.getCheckedOutBooks());
                size = library.getCheckedOutBooks().size();
            }


            String checkInProductChoice = sc.next();

            if (verifyListChoice(checkInProductChoice, size)) {

                Product product;

                if(film) {
                    product = library.getCheckedOutFilms().get(Integer.parseInt(checkInProductChoice));
                } else {
                    product = library.getCheckedOutBooks().get(Integer.parseInt(checkInProductChoice));
                }

                if(enterLoginDetails()) {
                    if (library.checkInProduct(product, film)) {
                        System.out.println("Thank you for returning: " + product.getTitle());
                    } else {
                        System.out.println("Sorry, that is not available");
                    }
                }
            }
        } else {
            System.out.println("No titles available!");
        }

    }

    private void chooseProductToCheckOut(boolean film){

        int size = 0;

        if(library.displayProductsToCheckOut(film)) {

            System.out.println("Please choose a product to check out by entering the corresponding number:");

            if(film) {
                displayProducts(library.getCheckedInFilms());
                size = library.getCheckedInFilms().size();
            } else {
                displayProducts(library.getCheckedInBooks());
                size = library.getCheckedInBooks().size();
            }


            String checkOutProductChoice = sc.next();

            if (verifyListChoice(checkOutProductChoice, size)) {

                Product product;

                if(film) {
                    product = library.getCheckedInFilms().get(Integer.parseInt(checkOutProductChoice));
                } else {
                    product = library.getCheckedInBooks().get(Integer.parseInt(checkOutProductChoice));
                }

                if(enterLoginDetails()) {
                    if (library.checkOutProduct(product, loggedInUser, film)) {
                        System.out.println("Successfully checked out: " + product.getTitle());
                        loggedInUser = "";
                    } else {
                        System.out.println("Sorry, that is not available");
                    }
                }
            }
        } else {
            System.out.println("No titles available!");
        }

    }

    public void displayProducts(ArrayList<Product> productList){

        //Display titles from book list
        int count = 0;

        for (Product product : productList) {

            System.out.print(count + ": ");
            System.out.print(product.returnInfo());

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
