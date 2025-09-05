package fr.univamu.progav.cours.cours3;

import java.util.Iterator;
import java.util.NoSuchElementException;

// 'Range' est un itérateur sur des entiers consécutifs. Il fournit les entiers
// un par un, à chaque appel de 'next'. C'est donc un 'Iterator'.

public class Range implements Iterator<Integer> {
  private int next;
  private final int max;

  public Range(int min, int max) {
    this.next = min;
    this.max = max;
  }

  public boolean hasNext() {
    return next <= max;
  }

  public Integer next() {
    if (!hasNext()) throw new NoSuchElementException();
    return next++;
  }


  public static void main(String[] args) {
    Iterator<Integer> range = new Range(1,10);
    int sum = 0;
    while (range.hasNext()) {
      int next = range.next();
      sum = sum + next;
      System.out.println(sum);
    }
  }
}

