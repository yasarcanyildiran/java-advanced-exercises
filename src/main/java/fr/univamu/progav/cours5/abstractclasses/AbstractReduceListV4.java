package fr.univamu.progav.cours5.abstractclasses;

import java.util.List;

// on rend la classe abstraite
public abstract class AbstractReduceListV4 {
  private final List<Integer> ints;

  public AbstractReduceListV4(List<Integer> ints) {
    this.ints = ints;
  }

  public int eval() {
    int sum = neutral();
    for (Integer i : ints) {
      sum = operator(sum, i);
    }
    return sum;
  }

  // on abstrait les méthodes représentant les comportements distincts.

  public abstract int neutral();

  public abstract int operator(int a, int b);
}


