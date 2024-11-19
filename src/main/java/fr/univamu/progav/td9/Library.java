package fr.univamu.progav.td9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
  private final Map<Book, BookStatus> bookStatuses = new HashMap<>();

  public void addBook(Book book) {
    bookStatuses.put(book, BookStatus.AVAILABLE);
  }

  public Book findBook(String isbn) {
    // TODO
    return null;
  }

  public void checkoutBook(Book book) throws BookException {
    // TODO
  }

  public BulkCheckoutResult checkoutBooks(List<Book> books) {
    // TODO
    return null;
  }

  public BookStatus getBookStatus(Book book) {
    // TODO
    return null;
  }
}
