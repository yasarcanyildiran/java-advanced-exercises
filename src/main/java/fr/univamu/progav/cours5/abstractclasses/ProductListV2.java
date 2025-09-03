package fr.univamu.progav.cours5.abstractclasses;

import java.util.List;

public class ProductListV2 {
  private final List<Integer> ints;

  public ProductListV2(List<Integer> ints) {
    this.ints = ints;
  }

  // on extrait les comportements distincts des comportements communs

  public int eval() {
    int product = neutral();
    for (Integer i : ints) {
      product = operator(product, i);
    }
    return product;
  }

  // chaque comportement distinct est déporté dans une méthode

  private  int operator(int a, int b) {
    return a * b;
  }

  private int neutral() {
    return 1;
  }


}

