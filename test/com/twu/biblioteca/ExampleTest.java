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

        assertTrue(lib.checkOutProduct(lib.getCheckedInBooks().get(0), "123-4567", false));

    }

    @Test
    public void testCheckInBookWithNoBooksToCheckIn(){

        assertFalse(lib.checkInProduct(new Book("Example book", "Author", 1990), false));

    }

    @Test
    public void testCheckInBookWithValidBook(){

        lib.checkOutProduct(lib.getCheckedInBooks().get(2), "123-4567", false);
        assertTrue(lib.checkInProduct(lib.getCheckedOutBooks().get(0), false));

    }

    @Test
    public void testDisplayBooksToCheckOutWithValidList(){

        assertTrue(lib.displayProductsToCheckOut(false));

    }

    @Test
    public void testDisplayBooksToCheckOutWhenAllBooksCheckedOut(){

        //All 3 books get checked out, so there aren't any available

        lib.checkOutProduct(lib.getCheckedInBooks().get(0), "123-4567", false);
        lib.checkOutProduct(lib.getCheckedInBooks().get(0), "123-4567", false);
        lib.checkOutProduct(lib.getCheckedInBooks().get(0), "123-4567", false);

        assertFalse(lib.displayProductsToCheckOut(false));

    }

    @Test
    public void testCheckingInFilm(){

        lib.checkOutProduct(lib.getCheckedInFilms().get(0), "123-4567", true);

        assertTrue(lib.checkInProduct(lib.getCheckedOutFilms().get(0), true));

    }

    @Test
    public void testDisplayFilmsToCheckInWhenEmpty(){

        assertFalse(lib.displayProductsToCheckIn(true));

    }
}
