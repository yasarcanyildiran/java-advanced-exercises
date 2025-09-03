package fr.univamu.progav.cours5.abstractclasses;

import java.util.List;

// On déclare une extension de la classe abstraite des comportements communs
public class ProductListV4 extends AbstractReduceListV4 {
  public ProductListV4(List<Integer> ints) {
    super(ints);
  }

  // On spécialise les comportements distincts selon la fonctionnalité voulue.

  @Override
  public int neutral() {
    return 1;
  }

  @Override
  public int operator(int a, int b) {
    return a * b;
  }
}
