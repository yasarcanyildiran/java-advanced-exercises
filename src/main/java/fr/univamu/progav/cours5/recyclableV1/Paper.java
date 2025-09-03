package fr.univamu.progav.cours5.recyclableV1;

public record Paper(double width, double height) {

  public void recycle() {
    System.out.println("make some cardboard.");
  }
}
