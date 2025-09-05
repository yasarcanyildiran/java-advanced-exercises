package fr.univamu.progav.td.td1;

import java.util.ArrayList;
import java.util.List;

public class Primes {

  public static List<Integer> primes(int max) {
    List<Integer> primes = new ArrayList<>();
    primes.add(2);
    for (int n = 3; n <= max; n = n + 2) {
      boolean isPossiblyPrime = true;
      for (int p : primes) {
        if (n % p == 0) {
          isPossiblyPrime = false;
          break;
        }
      }
      if (isPossiblyPrime) {
        primes.add(n);
      }
    }
    return primes;
  }

}
