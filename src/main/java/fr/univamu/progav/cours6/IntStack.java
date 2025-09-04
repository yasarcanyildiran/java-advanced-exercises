package fr.univamu.progav.cours6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntStack implements Iterable<Integer> {
  Integer[] values = new Integer[1000];
  Integer firstEmptyCell = 0;

  boolean isEmpty() {
    return firstEmptyCell == 0;
  }

  public void push(Integer value) {
    values[firstEmptyCell++] = value;
  }

  public Integer peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return values[firstEmptyCell - 1];
  }

  public Integer poll() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return values[--firstEmptyCell];
  }

  public Iterator<Integer> iterator() {
    return new IntStackIterator(values, firstEmptyCell-1);
  }

}
