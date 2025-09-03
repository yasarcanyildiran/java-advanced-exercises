package fr.univamu.progav.cours5.InductiveList;

public interface LinkedList<E> extends Iterable <E> {
  boolean isEmpty();

  E head();
  LinkedList<E> tail();

  int length();
  LinkedList<E> add(E elt);
}
