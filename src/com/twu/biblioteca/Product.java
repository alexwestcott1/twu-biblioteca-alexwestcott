package com.twu.biblioteca;

public class Product {

    private String owner = null;
    private boolean checkedOut;
    private String title;

    public Product(){
        checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getOwner(){ return owner; }

    public void setOwner(String owner){ this.owner = owner; }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public String returnInfo(){ return ""; };

}
