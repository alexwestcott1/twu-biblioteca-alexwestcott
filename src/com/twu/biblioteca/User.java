package com.twu.biblioteca;

import java.util.ArrayList;

public class User {

    private String name, email, phoneNo;
    private String libraryNumber;
    private String password;
    private ArrayList<Product> userProducts;

    public User(String libraryNumber, String password, String name, String email, String phoneNo) {

        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.libraryNumber = libraryNumber;
        this.password = password;
        userProducts = new ArrayList();

    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    private String getPassword() {
        return password;
    }


    public boolean attemptLogin(String libraryNumberAttempt, String passwordAttempt) {
        if (getLibraryNumber().equals(libraryNumberAttempt) && getPassword().equals(passwordAttempt)) {
            return true;
        }
        return false;
    }

    public String returnInfo() {
        return "Name: " + name + "\t|\tEmail: " + email + "\t|\tPhone number: " + phoneNo;
    }
}
