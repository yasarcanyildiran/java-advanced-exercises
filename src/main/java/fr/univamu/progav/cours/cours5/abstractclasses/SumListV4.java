package fr.univamu.progav.cours.cours5.abstractclasses;

import java.util.List;

// On déclare une extension de la classe abstraite des comportements communs
public class SumListV4 extends AbstractReduceListV4 {
  public SumListV4(List<Integer> ints) {
    super(ints);
  }

  // On spécialise les comportements distincts selon la fonctionnalité voulue.

  @Override
  public int neutral() {
    return 0;
  }

  @Override
  public int operator(int a, int b) {
    return a + b;
  }
}
