package fr.univamu.progav.cours.cours5.recyclableV2;

public record Paper(double width, double height) implements Recyclable {

  public void recycle() {
    System.out.println("make some cardboard.");
  }

  public void tear() {
    System.out.println("Tear some paper");
  }
}
