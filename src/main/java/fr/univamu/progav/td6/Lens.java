package fr.univamu.progav.td6;

public interface Lens<T> {
  void set(T t);
  T get();
}
