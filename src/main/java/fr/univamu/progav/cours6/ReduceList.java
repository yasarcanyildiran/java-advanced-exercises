package fr.univamu.progav.cours6;

import java.util.List;

// On améliore la solution du cours 5, en abstrayant non seulement le monoïde
// par une interface, mais aussi le type par généricité. Les deux techniques
// se combinent très bien.

public class ReduceList<T> {

  private final List<T> elements;
  private final Monoid<T> monoid;


  public ReduceList(List<T> elements, Monoid<T> monoid) {
    this.elements = elements;
    this.monoid = monoid;
  }

  public T reduce() {
    T result = monoid.neutral();
    for (T element : elements) {
      result = monoid.operator(result, element);
    }
    return result;
  }
}
