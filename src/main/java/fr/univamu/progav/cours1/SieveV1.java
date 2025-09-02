package fr.univamu.progav.cours1;

import java.util.ArrayList;
import java.util.List;

public class SieveV1 {

  // calcul de tous les nombres premiers jusqu'à 'max'
  public static List<Integer> allPrimes(int max) {
    List<Integer> primes = new ArrayList<>();
    for (int n = 2; n <= max; n++) {
      boolean isPrime = true;
      for (Integer prime : primes) {
        if (n % prime == 0) {
          isPrime = false;
        }
      }
      if (isPrime) {
        primes.add(n);
      }
    }
    return primes;
  }
}
