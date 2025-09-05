package fr.univamu.progav.td.td7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** A class to represent sets of consecutive integers.
 * @param mini the smallest integer in the set.
 * @param maxi the largest integer in the set. If maxi < mini, the set is empty.
 */
public record Interval(int mini, int maxi) implements Iterable<Integer> {

  /**
   * @param i an arbitrary integer
   * @return true if i is in the set
   */
  public boolean contains(int i) {
    // TODO
    return false;
  }

  /**
   * @return the number of integers in the set.
   */
  public int size() {
    // TODO
    return -1;
  }

  /**
   * @return true if this is empty.
   */
  public boolean isEmpty() {
    // TODO
    return false;
  }

  /** Decide whether two intervals intersect each other.
   * @param range the second interval
   * @return true if this and range intersect
   */
  public boolean intersects(Interval range) {
    // TODO
    return false;
  }

  /**
   * @return an iterator over the integers in the set
   */
  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      // TODO ajouter une propriété pour le prochain élément

      @Override
      public boolean hasNext() {
        // TODO
        return false;
      }

      @Override
      public Integer next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        // TODO
        return null;
      }
    } ;
  }
}
