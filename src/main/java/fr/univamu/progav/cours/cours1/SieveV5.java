package fr.univamu.progav.cours.cours1;

import java.util.ArrayList;
import java.util.List;

public class SieveV5 {

  public static List<Integer> allPrimes(int max) {
    List<Integer> primes = new ArrayList<>();
    for (int n = 2; n <= max; n++) {
      if (isPrime(primes, n)) {
        primes.add(n);
      }
    }
    return primes;
  }

  // En extrayant le test du 'if' dans sa propre méthode, on donne un
  // nom à la méthode, qui clarifie le rôle du test. C'est un petit
  // changement, mais la méthode en devient plus lisible.
  private static boolean isPrime(List<Integer> primes, int n) {
    for (Integer prime : primes) {
      if (divides(n, prime)) {
        return false;
      }
    }
    return true;
  }

  private static boolean divides(int n, int prime) {
    return n % prime == 0;
  }
}
