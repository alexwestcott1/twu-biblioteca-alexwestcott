package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest {

    private Library lib;
    private MainMenu menu;

    @Before
    public void setup(){

        lib = new Library();
        lib.setupLibrary();
        menu = new MainMenu(lib);

    }

    @Test
    public void testMenuOptionChosenLessThanListSize(){

        assertTrue(menu.verifyListChoice("0",1));

    }

    @Test
    public void testMenuOptionChosenLessThanListSize2(){

        assertTrue(menu.verifyListChoice("1", 2));

    }

    @Test
    public void testMenuOptionChosenMoreThanListSize(){

        assertFalse(menu.verifyListChoice("5", 3));

    }

    @Test
    public void testMenuOptionChosenNotANumber(){

        assertFalse(menu.verifyListChoice("badinput", 2));

    }

    @Test
    public void testMenuOptionChosenNegativeNumber(){

        assertFalse(menu.verifyListChoice("-2", 5));

    }

    @Test
    public void testCheckOutBookGivenValidBook(){

        assertTrue(lib.checkOutBook(lib.getCheckedInBooks().get(0), "123-4567"));

    }

    @Test
    public void testCheckInBookWithNoBooksToCheckIn(){

        assertFalse(lib.checkInBook(new Book("Example book", "Author", 1990)));

    }

    @Test
    public void testCheckInBookWithValidBook(){

        lib.checkOutBook(lib.getCheckedInBooks().get(2), "123-4567");
        assertTrue(lib.checkInBook(lib.getCheckedOutBooks().get(0)));

    }

    @Test
    public void testDisplayBooksToCheckOutWithValidList(){

        assertTrue(lib.displayBooksToCheckOut());

    }

    @Test
    public void testDisplayBooksToCheckOutWhenAllBooksCheckedOut(){

        //All 3 books get checked out, so there aren't any available

        lib.checkOutBook(lib.getCheckedInBooks().get(0), "123-4567");
        lib.checkOutBook(lib.getCheckedInBooks().get(0), "123-4567");
        lib.checkOutBook(lib.getCheckedInBooks().get(0), "123-4567");

        assertFalse(lib.displayBooksToCheckOut());

    }
}
