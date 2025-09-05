package fr.univamu.progav.cours.cours5.recyclableV1;

public record Can(double countenance) {

  public void recycle() {
    System.out.println("Melt aluminium.");
  }
}
