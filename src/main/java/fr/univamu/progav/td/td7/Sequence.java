package fr.univamu.progav.td.td7;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Sequence<T> {

  void forEach(Consumer<T> action);

  boolean anyMatch(Predicate<T> predicate);

  T maximum(Comparator<T> compare);
}
