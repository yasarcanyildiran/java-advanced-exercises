package fr.univamu.progav.cours5.abstractclasses;

import java.util.List;

public class ProductListV1 {
  private final List<Integer> ints;

  public ProductListV1(List<Integer> ints) {
    this.ints = ints;
  }

  public int eval() {
    int product = 1;
    for (Integer i : ints) {
      product = product * i;
    }
    return product;
  }

}

