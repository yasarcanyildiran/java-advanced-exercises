package fr.univamu.progav.cours.cours3;

import java.util.Iterator;
import java.util.function.DoubleUnaryOperator;

// 'Sequence' est une suite de nombres définis récursivement par une
// équation de la forme $u_{n+1} = f(u_n)$, $u_0 = c$. On doit
// pouvoir faire une boucle 'for' (infinie) sur les termes.
// 'Sequence' est donc 'Iterable'.

public class Sequence implements Iterable<Double> {
  private final DoubleUnaryOperator f;
  private final double initialValue;

  public Sequence(DoubleUnaryOperator f, double x0) {
    this.f = f; this.initialValue = x0;
  }

  public double term(int i) {
    for (Double d : this) {
      if (i == 0) return d;
      i--;
    }
    return 0;
  }

  public Iterator<Double> iterator() {
    return new SequenceIterator(f,initialValue);
  }

  public static void main(String[] args) {
    Sequence seq = new Sequence(x -> 2 * x + 1, 1);
    for (int i = 0; i < 10; i++) {
      System.out.println(seq.term(i));
    }
  }
}
