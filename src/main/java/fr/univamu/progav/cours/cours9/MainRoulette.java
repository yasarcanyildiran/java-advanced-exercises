package fr.univamu.progav.cours.cours9;

public class MainRoulette {

  // Exemple d'une méthode pouvant propager l'exception

  private static void playThreeTimes(Roulette roulette)
  throws Roulette.ZeroException {
    for (int i = 0; i < 3; i++) {
      System.out.println(
        (roulette.roll() % 2 == 0) ? "Pair" : "Impair"
      );
    }
  }


  // Exemple d'une méthode pouvant rattraper l'exception

  public static void main(String[] args) {
    Roulette roulette = new Roulette();
    try {
      playThreeTimes(roulette);
    }
    catch (Roulette.ZeroException exc) {
      System.out.println("Zéro, la banque prend tout !");
    }
  }

}
