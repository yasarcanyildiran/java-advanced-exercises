package fr.univamu.progav.cours4;

public class Point2D {
  record Vector2D(double x, double y) {

    // propriétés statiques
    public static final Vector2D NULL = new Vector2D(0,0);
    public static final Vector2D[] roots6 = new Vector2D[6];

    // initialiseur statique
    static {
      for (int i = 0; i < 6; i++) {
        roots6[i] = polar(1, i * Math.PI / 6);
      }
    }

    // méthode statique
    public static Vector2D polar(double norm,
      double angle) {
      return new Vector2D(norm * Math.cos(angle),norm * Math.sin(angle));
    }

    // méthode d'objet
    public Vector2D add(Vector2D addend) {
      return new Vector2D(this.x + addend.x,this.y + addend.y);
    }
  }
}
