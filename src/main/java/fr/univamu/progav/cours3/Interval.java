package fr.univamu.progav.cours3;

import java.util.Iterator;

// 'Interval' représente une séquence d'entiers consécutifs. On doit pouvoir
// faire une boucle 'for' sur ces entiers. 'Interval' implémente donc 'Iterable'.

public class Interval implements Iterable<Integer> {
  public final int start;
  public final int stop;

  public Interval(int start, int stop) {
    this.start = start;
    this.stop = stop;
  }

  public static final Interval EMPTY = new Interval(0,-1);

  public Iterator<Integer> iterator() {
    return new Range(start,stop);
  }

  public boolean isEmpty() {
    return start < stop;
  }

  public Interval union(Interval interval) {
    if (interval.isEmpty()) return this;
    if (this.isEmpty()) return interval;
    return new Interval(
      Math.min(this.start, interval.start),
      Math.max(this.stop, interval.stop)
    );
  }

  public static void main(String[] args) {
    int sum = 0;
    for (int next : new Interval(1,10)) {
      sum = sum + next;
      System.out.println(sum);
    }
  }
}

