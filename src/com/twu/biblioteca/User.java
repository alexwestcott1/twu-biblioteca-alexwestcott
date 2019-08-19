package com.twu.biblioteca;

import java.util.ArrayList;

public class User {

    private String libraryNumber;
    private String password;
    private ArrayList<Product> userProducts;

    public User(String libraryNumber, String password) {

        this.libraryNumber = libraryNumber;
        this.password = password;
        userProducts = new ArrayList();

    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }


    public boolean attemptLogin(String libraryNumberAttempt, String passwordAttempt) {
        if (getLibraryNumber().equals(libraryNumberAttempt) && getPassword().equals(passwordAttempt)) {
            return true;
        }
        return false;
    }
}
