package fr.univamu.progav.cours3;


import java.util.Iterator;
import java.util.function.DoubleUnaryOperator;


// 'SequenceIterator' fournit les termes d'une suite mathématique un par
// un, à chaque appel de 'next'. C'est un 'Iterator'.

public class SequenceIterator implements Iterator<Double> {
  private final DoubleUnaryOperator f;
  private double nextValue;

  public SequenceIterator(DoubleUnaryOperator f, double x0) {
    this.f = f;
    this.nextValue = x0;
  }

  public boolean hasNext() { return true; }

  public Double next() {
    double current = nextValue;
    nextValue = f.applyAsDouble(nextValue);
    return current;
  }



  public static void main(String[] args) {
    double target = 10;
    double epsilon = 1e-6;
    Sequence newtonRoot = new Sequence(x -> 0.5 * (x + target / x), target);
    for (Double possibleRoot : newtonRoot) {
      System.out.println(possibleRoot);
      if (Math.abs(Math.pow(possibleRoot, 2) - target) < epsilon) {
        break;
      }
    }
  }

}

