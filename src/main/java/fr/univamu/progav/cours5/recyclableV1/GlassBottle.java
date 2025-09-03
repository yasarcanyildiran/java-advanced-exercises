package fr.univamu.progav.cours5.recyclableV1;

public record GlassBottle(double countenance, double weight) {

  public void recycle() {
    System.out.println("Melt glass.");
  }
}
