package fr.univamu.progav.td.td2;

public class Ratio {

  private final int num;
  private final int denom;

  private Ratio(int num, int denom) {
    this.num = num;
    this.denom = denom;
  }

  /** Builds a ratio, given its numerator and denominator
   * @param num the numerator of the ratio
   * @param denom the denominator of the ratio
   * @return a reduced ratio equals to num/denom, represented in reduced form.
   */
  public static Ratio of(int num, int denom) {
    int d = gcd(denom, num);
    return new Ratio(num / d, denom /d );
  }

  // UnsafeOf is used in test, to build a ratio without reducing it,
  // and must be used with already reduced numerator and denominator.
  protected static Ratio unsafeOf(int num, int denom) {
    return new Ratio(num, denom);
  }

  // Euclid's algorithm
  public static int gcd(int a, int b) {
    return a == 0 || b == 0? a + b:
           gcd(b, a % b);
  }


  public Ratio plus(Ratio r) {
    return of(this.num * r.denom + this.denom * r.num, this.denom * r.denom);
  }


  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Ratio r)) {
      return false;
    }
    return r.num == this.num && r.denom == this.denom;
  }

  @Override
  public String toString() {
    double value = this.num / (double) this.denom;
    return String.valueOf(value);
  }
}
