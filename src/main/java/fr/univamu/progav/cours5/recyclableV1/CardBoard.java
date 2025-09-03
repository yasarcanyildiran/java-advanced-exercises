package fr.univamu.progav.cours5.recyclableV1;

public record CardBoard(double thickness, double area) {

  public void recycle() {
    System.out.println("Burn cardboard.");
  }
}
