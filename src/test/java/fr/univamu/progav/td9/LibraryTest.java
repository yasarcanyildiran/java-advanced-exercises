package fr.univamu.progav.td9;

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
    library.checkoutBook(book1);
    assertEquals(BookStatus.BORROWED, library.getBookStatus(book1));
  }

  @Test
  void testBulkCheckoutPartialSuccess() throws BookException {
    library.checkoutBook(book1);
    Book nonExistentBook = new Book("999", "Nonexistent");
    List<Book> booksToCheckout = List.of(book1, book2, nonExistentBook);
    BulkCheckoutResult result = library.checkoutBooks(booksToCheckout);
    assertFalse(result.isCompletelySuccessful());
    assertEquals(1, result.successfulCheckouts().size());
    assertEquals(2, result.failedCheckouts().size());
    assertInstanceOf(BookUnavailableException.class, result.failedCheckouts().get(0));
    assertInstanceOf(BookNotFoundException.class, result.failedCheckouts().get(1));
    assertEquals(book1,result.failedCheckouts().get(0).book());
    assertEquals(nonExistentBook,result.failedCheckouts().get(1).book());
  }

  @Test
  void testBulkCheckoutAllSuccess() {
    List<Book> booksToCheckout = List.of(book1, book2);
    BulkCheckoutResult result = library.checkoutBooks(booksToCheckout);

    assertTrue(result.isCompletelySuccessful());
    assertEquals(2, result.successfulCheckouts().size());
    assertTrue(result.failedCheckouts().isEmpty());
  }
}
