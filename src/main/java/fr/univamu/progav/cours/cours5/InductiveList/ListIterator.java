package fr.univamu.progav.cours.cours5.InductiveList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator<E> {

  private AbstractLinkedList<E> list;

  public ListIterator(AbstractLinkedList<E> list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    return !list.isEmpty();
  }

  @Override
  public E next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException();
    }
    E next = list.head();
    list = list.tail();
    return next;
  }
}
