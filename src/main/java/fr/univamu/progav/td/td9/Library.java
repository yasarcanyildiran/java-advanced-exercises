package fr.univamu.progav.td.td9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

  private final Map<String, Book> collection = new HashMap<>();
  private final Map<Book, BookStatus> bookStatuses = new HashMap<>();

  public void addBook(Book book) {
    collection.put(book.isbn(), book);
    bookStatuses.put(book, BookStatus.AVAILABLE);
  }

  public Book findBook(String isbn) {
    // TODO
    return null;
  }


  public BookStatus getBookStatus(String isbn) {
    // TODO
    return null;
  }

  public Book checkoutBook(String isbn) {
    // TODO
    return null;
  }

  public BulkCheckoutResult checkoutBooks(List<String> isbns) {
    // TODO
    return null;
  }

}
