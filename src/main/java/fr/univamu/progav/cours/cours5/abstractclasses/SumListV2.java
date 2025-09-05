package fr.univamu.progav.cours.cours5.abstractclasses;

import java.util.List;

public class SumListV2 {
  private final List<Integer> ints;

  // on extrait les comportements distincts des comportements communs

  public SumListV2(List<Integer> ints) {
    this.ints = ints;
  }

  public int eval() {
    int sum = neutral();
    for (Integer i : ints) {
      sum = operator(sum, i);
    }
    return sum;
  }

  // chaque comportement distinct est déporté dans une méthode

  public int neutral() {
    return 0;
  }

  public int operator(int a, int b) {
    return a + b;
  }
}


