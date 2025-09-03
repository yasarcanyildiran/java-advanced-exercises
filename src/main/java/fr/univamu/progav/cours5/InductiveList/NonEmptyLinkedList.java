package fr.univamu.progav.cours5.InductiveList;

public final class NonEmptyLinkedList<E> extends AbstractLinkedList<E> {
  private final E head;
  private final AbstractLinkedList<E> tail;

  public NonEmptyLinkedList(E head, AbstractLinkedList<E> tail) {
    this.head = head;
    this.tail = tail;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public E head() {
    return this.head;
  }

  @Override
  public AbstractLinkedList<E> tail() {
    return this.tail;
  }

  @Override
  public int length() {
    return 1 + tail.length();
  }
}
