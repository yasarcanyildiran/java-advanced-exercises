package fr.univamu.progav.cours.cours5.recyclableV2;

public record Can(double countenance) implements Recyclable {

  public void recycle() {
    System.out.println("Melt aluminium.");
  }
}
