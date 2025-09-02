package fr.univamu.progav.cours1;

import java.util.ArrayList;
import java.util.List;

public class SieveV3 {

  public static List<Integer> allPrimes(int max) {
    List<Integer> primes = new ArrayList<>();
    for (int n = 2; n <= max; n++) {
      // On extrait en une méthode le test de primalité de 'n', on appelle la
      // nouvelle méthode directement dans la condition du 'if'
      if (isPrime(primes, n)) {
        primes.add(n);
      }
    }
    return primes;
  }

  private static boolean isPrime(List<Integer> primes, int n) {
    boolean isPrime = true;
    for (Integer prime : primes) {
      if (n % prime == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }
}
