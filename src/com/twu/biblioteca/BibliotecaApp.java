package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library lib = new Library();
        lib.setupLibrary();
        MainMenu menu = new MainMenu(lib);
        menu.runApplication();
    }
}
