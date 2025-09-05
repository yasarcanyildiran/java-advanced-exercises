package fr.univamu.progav.td.td6;

public interface Lens<T> {
  void set(T t);
  T get();
}
