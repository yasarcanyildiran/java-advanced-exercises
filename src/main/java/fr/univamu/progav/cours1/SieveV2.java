package fr.univamu.progav.cours1;

import java.util.ArrayList;
import java.util.List;

public class SieveV2 {

  public static List<Integer> allPrimes(int max) {
    List<Integer> primes = new ArrayList<>();
    for (int n = 2; n <= max; n++) {
      boolean isPrime = true;
      for (Integer prime : primes) {
        if (n % prime == 0) {
          isPrime = false;
          break; // l'ajout du 'break' permet de sortir du 'for' et sauter ligne 18.
        }
      }
      if (isPrime) {
        primes.add(n);
      }
    }
    return primes;
  }
}
