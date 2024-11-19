package fr.univamu.progav.td9;

public record Book(String isbn, String title) {

  @Override
  public String toString() {
    return title + " (" + isbn + ")";
  }
}
