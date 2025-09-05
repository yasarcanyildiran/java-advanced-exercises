package fr.univamu.progav.cours.cours5.recyclableV2;

public record CardBoard(double thickness, double area) implements Recyclable {

  public void recycle() {
    System.out.println("Burn cardboard.");
  }
}
