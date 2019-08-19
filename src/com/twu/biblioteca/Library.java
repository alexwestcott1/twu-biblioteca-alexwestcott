package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    //ArrayList that contains all titles

    private ArrayList<Product> checkedInBooks = new ArrayList<Product>();
    private ArrayList<Product> checkedOutBooks = new ArrayList<Product>();
    private ArrayList<Product> checkedInFilms = new ArrayList<Product>();
    private ArrayList<Product> checkedOutFilms = new ArrayList<Product>();
    private ArrayList<User> libraryUsers = new ArrayList<User>();

    public void setupLibrary() {

        checkedInBooks.add(new Book("To Kill A Mockingbird", "Harper Lee", 1960));
        checkedInBooks.add(new Book("Harry Potter", "JK Rowling", 2002));
        checkedInBooks.add(new Book("The Hobbit", "JRR Tolkien", 1937));

        checkedInFilms.add(new Film("GoodFellas", "Martin Scorsese", 1990, 9));
        checkedInFilms.add(new Film("American Beauty", "Sam Mendes", 1999, 8));
        checkedInFilms.add(new Film("Get Out", "Jordan Peele", 2017, 7));

        libraryUsers.add(new User("123-4567", "lemons"));
        libraryUsers.add(new User("555-5555", "apples"));
        libraryUsers.add(new User("999-1234", "oranges"));

    }

    public ArrayList<Product> getCheckedInBooks(){

        return checkedInBooks;

    }

    public ArrayList<Product> getCheckedOutBooks(){

        return checkedOutBooks;

    }

    public ArrayList<Product> getCheckedInFilms() {
        return checkedInFilms;
    }

    public ArrayList<Product> getCheckedOutFilms() {
        return checkedOutFilms;
    }

    public boolean displayProductsToCheckIn(boolean film){

        if(film) {
            if (getCheckedOutFilms().size() > 0) {
                return true;
            }
        } else {
            if (getCheckedOutBooks().size() > 0) {
                return true;
            }
        }

        return false;

    }

    public boolean displayProductsToCheckOut(boolean film){

        if(film) {
            if (getCheckedInFilms().size() > 0) {
                return true;
            }
        } else {
            if (getCheckedInBooks().size() > 0) {
                return true;
            }
        }

        return false;

    }


    public boolean checkOutProduct(Product product, String owner, boolean film){

        if (!product.isCheckedOut()) {

            product.setCheckedOut(true);
            product.setOwner(owner);

            if(film) {
                getCheckedInFilms().remove(product);
                getCheckedOutFilms().add(product);
                return true;
            } else {
                getCheckedInBooks().remove(product);
                getCheckedOutBooks().add(product);
                return true;
            }
        }

        return false;

    }

    public boolean checkInProduct(Product product, boolean film){



        if (product.isCheckedOut()) {
            product.setCheckedOut(false);
            product.setOwner(null);

            if(film) {
                getCheckedOutFilms().remove(product);
                getCheckedInFilms().add(product);
                return true;
            } else {
                getCheckedOutBooks().remove(product);
                getCheckedInBooks().add(product);
                return true;
            }
        }

        return false;

    }

    public boolean validateLogin(String libraryNumber, String password){

        boolean userValid = false;


        if(getUserFromID(libraryNumber) != null){
            userValid = getUserFromID(libraryNumber).attemptLogin(libraryNumber,password);
            return userValid;
        }

        return userValid;

    }

    public User getUserFromID(String id){

        for(User user : libraryUsers){
            if(user.getLibraryNumber().equals(id)){
                return user;
            }
        }

        return null;

    }




}
