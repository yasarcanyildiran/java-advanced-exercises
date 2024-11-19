package fr.univamu.progav.td9;

import java.util.List;

public record BulkCheckoutResult(
  List<Book> successfulCheckouts,
  List<BookException> failedCheckouts
) {


  public boolean isCompletelySuccessful() {
    // TODO
    return false;
  }

}
