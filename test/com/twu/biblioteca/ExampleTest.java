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
    public void testMenuOptionChosen(){

        Library lib = new Library();
        lib.setupLibrary();
        MainMenu menu = new MainMenu(lib);

        assertTrue(menu.verifyListChoice("0",1));
        assertTrue(menu.verifyListChoice("1", 2));
        assertFalse(menu.verifyListChoice("5", 3));
        assertFalse(menu.verifyListChoice("badinput", 2));
        assertFalse(menu.verifyListChoice("-2", 5));

    }
}
