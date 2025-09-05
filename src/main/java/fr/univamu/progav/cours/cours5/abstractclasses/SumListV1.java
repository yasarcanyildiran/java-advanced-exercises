package fr.univamu.progav.cours.cours5.abstractclasses;

import java.util.List;

public class SumListV1 {
  private final List<Integer> ints;

  public SumListV1(List<Integer> ints) {
    this.ints = ints;
  }

  public int eval() {
    int sum = 0;
    for (Integer i : ints) {
      sum = sum + i;
    }
    return sum;
  }
}


