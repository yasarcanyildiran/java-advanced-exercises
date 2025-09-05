package fr.univamu.progav.cours.cours1;

import java.util.ArrayList;
import java.util.List;

public class SieveV4 {

  public static List<Integer> allPrimes(int max) {
    List<Integer> primes = new ArrayList<>();
    for (int n = 2; n <= max; n++) {
      if (isPrime(primes, n)) {
        primes.add(n);
      }
    }
    return primes;
  }

  // On utilise l'early-exit, en faisant un 'return' dès que la solution
  // est connue, ce qui permet de supprimer la variable 'isPrime'.
  // Le 'break' devient un 'return'
  private static boolean isPrime(List<Integer> primes, int n) {
    for (Integer prime : primes) {
      if (n % prime == 0) {
        return false;
      }
    }
    return true;
  }
}
