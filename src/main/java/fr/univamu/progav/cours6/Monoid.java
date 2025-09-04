package fr.univamu.progav.cours6;

public interface Monoid<T> {
  T neutral();
  T operator(T a, T b);
}
