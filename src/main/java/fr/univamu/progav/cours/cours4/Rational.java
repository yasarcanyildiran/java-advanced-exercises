package fr.univamu.progav.cours.cours4;

public record Rational(int denom, int num) {

  // constructeur redéfinit
  public Rational(int denom, int num) {
    // Validité des valeurs :
    if (num == 0) { throw new ArithmeticException(); }
    // Normalisation :
    int g = gcd(Math.abs(denom), Math.abs(num));
    int sign = ((num >= 0) == (denom > 0)) ? 1 : -1;
    this.denom = sign * Math.abs(denom) / g;
    this.num = Math.abs(num) /g;
  }


  private static int gcd(int a, int b) {
    while (b > 0) {
      int remain = a % b;
      a = b;  b = remain;
    }
    return a;
  }
}

