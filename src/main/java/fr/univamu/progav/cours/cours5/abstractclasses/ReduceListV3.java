package fr.univamu.progav.cours.cours5.abstractclasses;

import java.util.List;

public class ReduceListV3 {

  // On crée une interface regroupant les comportements distincts
  // (on peut la mettre dans son propre fichier)
  public interface IntMonoid {
    int neutral();
    int operator(int a, int b);
  }

  private final List<Integer> ints;
  // on ajoute un objet pour les comportements distincts
  private final IntMonoid monoid;



  // on initialise l'objet que recevra la délégation, par exemple dans le constructeur
  public ReduceListV3(List<Integer> ints, IntMonoid monoid) {
    this.ints = ints;
    this.monoid = monoid;
  }

  // on délègue les comportements distincts au nouvel objet
  public int eval() {
    int sum = monoid.neutral();
    for (Integer i : ints) {
      sum = monoid.operator(sum, i);
    }
    return sum;
  }

  // On peut ajouter des fabriquants statiques pour revenir sur
  // les fonctionnalités initiales

  static class SumMonoid implements ReduceListV3.IntMonoid {
    public int neutral() { return 0; }
    public int operator(int a, int b) { return a + b; }
  }

  public static ReduceListV3 sumList(List<Integer> ints) {
    return new ReduceListV3(ints, new SumMonoid());
  }

  static class ProductMonoid implements IntMonoid {
    public int neutral() { return 1; }
    public int operator(int a, int b) { return a * b; }
  }

  public static ReduceListV3 productList(List<Integer> ints) {
    return new ReduceListV3(ints, new ProductMonoid());
  }
}


