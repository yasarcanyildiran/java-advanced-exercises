package fr.univamu.progav.td2;

public class GuessingGame {

  public static int solve(int mystery) {
    return new GuessingGame(mystery).nbAttempts();
  }

  public static final int LOWER_BOUND = 1;
  public static final int UPPER_BOUND = 1000;

  private final int mystery;
  private int attempts = 0;

  public GuessingGame(int mystery) {
    this.mystery = mystery;
    guess(LOWER_BOUND, UPPER_BOUND);
  }

  private int nbAttempts() {
    return attempts;
  }

  private void guess(int lowerBound, int upperBound) {
    this.attempts++;
    if (lowerBound == upperBound) {
      return;
    }
    int middle = (upperBound + lowerBound) / 2;
    if (middle == mystery) {
      return;
    }
    if (middle < mystery) {
      guess(middle,upperBound);
    } else {
      guess(lowerBound,middle-1);
    }

  }

}
