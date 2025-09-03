package fr.univamu.progav.cours5.recyclableV2;

public record GlassBottle(double countenance, double weight) implements Recyclable {

  public void recycle() {
    System.out.println("Melt glass.");
  }
}
