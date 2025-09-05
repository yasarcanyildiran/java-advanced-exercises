package fr.univamu.progav.td2;

import fr.univamu.progav.td.td2.GuessingGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessingGameTest {

  @Test
  void solve() {
    int max_allowed = // a bound on the minimum number of guesses by the best strategy.
      (int) Math.ceil(log2(GuessingGame.UPPER_BOUND - GuessingGame.LOWER_BOUND + 2,1e-1));
    for (int i = GuessingGame.LOWER_BOUND; i <= GuessingGame.UPPER_BOUND; i++) {
      int r = GuessingGame.solve(i);
      assertTrue(r <= max_allowed,
        "Guessing " + i + " in " + r + "/" + max_allowed + " attempts");
    }
  }

  // compute log(x) in base 2, with given precision, for instance log2(x,1e-6)
  // is at most 0.000001 away from the exact value.
  private static double log2(double x, double precision) {
    return
      (x >= 2)? 1 + log2(x/2, precision):
      (x == 1)? 0:
      (x < 1)? - log2(1/x, precision):
      (precision > 1) ? 0:
      0.5 * log2(x * x, precision*2);
  }
}