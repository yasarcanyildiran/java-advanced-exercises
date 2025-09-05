package fr.univamu.progav.cours.cours5.InductiveList;

import java.util.Iterator;


public abstract sealed class AbstractLinkedList<E> implements LinkedList<E>
  permits EmptyLinkedList, NonEmptyLinkedList {

  public abstract boolean isEmpty();
  public abstract E head();
  public abstract AbstractLinkedList<E> tail();
  public abstract int length();

  public AbstractLinkedList<E> add(E elt) {
    return new NonEmptyLinkedList<>(elt,this);
  }
  public Iterator<E> iterator() {
    return new ListIterator<E>(this);
  }
}
