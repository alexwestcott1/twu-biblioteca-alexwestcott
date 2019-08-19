package com.twu.biblioteca;

public class Film extends Product {

    private String title;
    private String filmDirector;
    private int yearReleased;
    private int filmRating;

    public Film(String title, String filmDirector, int yearReleased, int filmRating){

        this.title = title;
        this.filmDirector = filmDirector;
        this.yearReleased = yearReleased;
        this.filmRating = filmRating;

    }

    public String getTitle(){

        return title;

    }

    @Override
    public String returnInfo(){
        String info = "";

        info += title + "\t|\tDirector: " + filmDirector + "\t|\tReleased in " + yearReleased + "\t|\tFilm rating: " + filmRating;

        if(isCheckedOut()){
            info += "\t|\tChecked out by: " + getOwner();
        }

        return info;
    }

}
