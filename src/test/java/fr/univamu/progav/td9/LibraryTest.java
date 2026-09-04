package fr.univamu.progav.td9;

import fr.univamu.progav.td.td9.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

  private Library library;
  private Book book1;
  private Book book2;
  private Book book3;

  @BeforeEach
  void setUp() {
    library = new Library();
    book1 = new Book("123", "Livre 1");
    book2 = new Book("456", "Livre 2");
    book3 = new Book("789", "Livre 3");
    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
  }

  @Test
  void testFindBookThrowsException() {
    assertThrows(BookNotFoundException.class, () -> {
      library.findBook("999");
    });
  }

  @Test
  void testSingleCheckoutSuccess() throws BookException {
    library.checkoutBook("123");
    assertEquals(BookStatus.BORROWED, library.getBookStatus("123"));
  }

  @Test
  void testBulkCheckoutPartialSuccess() throws BookException {
    library.checkoutBook("123");
    Book nonExistentBook = new Book("999", "Nonexistent");
    List<String> booksToCheckout = List.of("123", "456", "999");
    BulkCheckoutResult result = library.checkoutBooks(booksToCheckout);
    assertFalse(result.isCompletelySuccessful());
    assertEquals(1, result.successfulCheckouts().size());
    assertEquals(2, result.failedCheckouts().size());
    assertInstanceOf(BookUnavailableException.class, result.failedCheckouts().get(0));
    assertInstanceOf(BookNotFoundException.class, result.failedCheckouts().get(1));
    assertEquals(
      "Livre 1 (123): book unavailable",
      result.failedCheckouts().get(0).getMessage()
    );
    assertEquals(
      "Nonexistent (999): book not found",
      result.failedCheckouts().get(1).getMessage()
    );
  }

  @Test
  void testBulkCheckoutAllSuccess() {
    List<String> booksToCheckout = List.of("123", "456");
    BulkCheckoutResult result = library.checkoutBooks(booksToCheckout);

    assertTrue(result.isCompletelySuccessful());
    assertEquals(2, result.successfulCheckouts().size());
    assertTrue(result.failedCheckouts().isEmpty());
  }
}
