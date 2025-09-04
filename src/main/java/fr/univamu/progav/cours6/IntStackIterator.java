package fr.univamu.progav.cours6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntStackIterator implements Iterator<Integer> {

  private final Integer[] values;
  private int current = 0;
  private final int last;

  public IntStackIterator(Integer[] values, int last) {
    this.values = values;
    this.last = last;
  }


  public boolean hasNext() {
    return current <= last;
  }

  public Integer next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return values[current++];
  }
}

