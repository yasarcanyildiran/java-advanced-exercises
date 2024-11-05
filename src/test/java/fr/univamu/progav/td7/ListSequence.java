package fr.univamu.progav.td7;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListSequence<T> implements Sequence<T> {
// Ne pas modifier cette classe !
  private final List<T> elements;


  public ListSequence(List<T> elements) {
    this.elements = elements;
  }

  @SafeVarargs
  public ListSequence(T... elements) {
    this.elements = Arrays.asList(elements);
  }

  public void forEach(Consumer<T> action) {
    elements.forEach(action);
  }

  public boolean anyMatch(Predicate<T> predicate) {
    return elements.stream().anyMatch(predicate);
  }

  public T maximum(Comparator<T> compare) {
    return elements.stream().max(compare).orElse(null);
  }
}

