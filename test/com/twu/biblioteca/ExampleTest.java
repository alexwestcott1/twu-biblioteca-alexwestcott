package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest {

    @Test
    public void testIfMenuIsEmpty() {

        Library library = new Library();
        assertFalse(library.displayBooksToCheckIn());
        assertFalse(library.displayBooksToCheckOut());


    }

    @Test
    public void testMenuOptionChosenLessThanListSize(){

        Library lib = new Library();
        lib.setupLibrary();
        MainMenu menu = new MainMenu(lib);

        assertTrue(menu.verifyListChoice("0",1));

    }

    @Test
    public void testMenuOptionChosenLessThanListSize2(){

        Library lib = new Library();
        lib.setupLibrary();
        MainMenu menu = new MainMenu(lib);

        assertTrue(menu.verifyListChoice("1", 2));

    }

    @Test
    public void testMenuOptionChosenMoreThanListSize(){

        Library lib = new Library();
        lib.setupLibrary();
        MainMenu menu = new MainMenu(lib);

        assertFalse(menu.verifyListChoice("5", 3));

    }

    @Test
    public void testMenuOptionChosenNotANumber(){

        Library lib = new Library();
        lib.setupLibrary();
        MainMenu menu = new MainMenu(lib);

        assertFalse(menu.verifyListChoice("badinput", 2));

    }

    @Test
    public void testMenuOptionChosenNegativeNumber(){

        Library lib = new Library();
        lib.setupLibrary();
        MainMenu menu = new MainMenu(lib);

        assertFalse(menu.verifyListChoice("-2", 5));

    }
}
