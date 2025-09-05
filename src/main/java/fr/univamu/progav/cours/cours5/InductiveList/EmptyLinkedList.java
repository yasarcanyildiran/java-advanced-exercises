package fr.univamu.progav.cours.cours5.InductiveList;

import java.security.InvalidParameterException;

public final class EmptyLinkedList<E> extends AbstractLinkedList<E> {
  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public E head() {
    throw new InvalidParameterException("head of empty list");
  }

  @Override
  public AbstractLinkedList<E> tail() {
    throw new InvalidParameterException("tail of empty list");
  }

  @Override
  public int length() {
    return 0;
  }
}
