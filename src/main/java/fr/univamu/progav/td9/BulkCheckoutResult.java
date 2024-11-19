package fr.univamu.progav.td9;

import java.util.ArrayList;
import java.util.List;

public record BulkCheckoutResult(
  List<Book> successfulCheckouts,
  List<BookException> failedCheckouts
) {

  public BulkCheckoutResult() {
    this(new ArrayList<>(), new ArrayList<>());
  }

  public boolean isCompletelySuccessful() {
    // TODO
    return false;
  }

}
