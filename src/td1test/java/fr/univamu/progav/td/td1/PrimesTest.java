package fr.univamu.progav.td.td1;

import fr.univamu.progav.td.td1.Primes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimesTest {

  public static final List<Integer> PRIMES = List.of(2,
    3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
    53, 59, 61, 67, 71, 73, 79, 83, 89, 97
  );

  @Test
  void primes() {
    List<Integer> primesTo100 = Primes.primes(100);
    assertEquals(PRIMES, primesTo100);
  }

  void includesBound() {
    List<Integer> primesTo83 = Primes.primes(83);
    assertTrue(primesTo83.contains(83));
  }
}