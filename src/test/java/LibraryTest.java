import org.example.Book;
import org.example.DVD;
import org.example.Library;
import org.example.Patron;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Patron patron;
    private Book book;
    private DVD dvd;

    @BeforeEach
    void setUp() {
        library = new Library();
        patron = new Patron("John Doe", "P001");
        book = new Book("The Catcher in the Rye", "B001", "J.D. Salinger");
        dvd = new DVD("Inception", "D001", 180);
    }

    @Test
    void testRegisterPatron() {
        library.registerPatron(patron);
        assertTrue(library.getPatrons().contains(patron));
    }

    @Test
    void testBorrowAndReturnItem() {
        library.add(book);
        library.registerPatron(patron);

        library.lendItem(patron, book);
        assertTrue(patron.getBorrowedItems().contains(book));
        assertTrue(book.isBorrowed());

        library.returnItem(patron, book);
        assertFalse(patron.getBorrowedItems().contains(book));
        assertFalse(book.isBorrowed());
    }

    @Test
    void testLendUnavailableItem() {
        library.add(dvd);
        library.registerPatron(patron);

        library.lendItem(patron, dvd);
        assertTrue(patron.getBorrowedItems().contains(dvd));
        assertTrue(dvd.isBorrowed());
    }

    @Test
    void testReturnUnborrowedItem() {
        library.add(book);
        library.registerPatron(patron);

        library.returnItem(patron, book);
        assertFalse(patron.getBorrowedItems().contains(book));
        assertFalse(book.isBorrowed());
    }
}

