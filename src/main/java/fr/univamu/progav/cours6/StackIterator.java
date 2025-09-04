package fr.univamu.progav.cours6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIterator<T> implements Iterator<T> {

  private final T[] values;
  private int current = 0;
  private final int last;

  public StackIterator(T[] values, int last) {
    this.values = values;
    this.last = last;
  }


  public boolean hasNext() {
    return current <= last;
  }

  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return values[current++];
  }
}

