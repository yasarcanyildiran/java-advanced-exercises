package fr.univamu.progav.cours6;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Stack<T> implements Iterable<Integer> {
  @SuppressWarnings("unchecked") // autorise le cast ci-dessous.
  T[] values = (T[]) new Object[1000]; // Cast obligatoire, incompatibilité entre générique et tableau
  Integer firstEmptyCell = 0;

  boolean isEmpty() {
    return firstEmptyCell == 0;
  }

  public void push(T value) {
    values[firstEmptyCell++] = value;
  }

  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return values[firstEmptyCell - 1];
  }

  public T poll() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return values[--firstEmptyCell];
  }

  public Iterator<Integer> iterator() {
    return new StackIterator(values, firstEmptyCell-1);
  }

}
