package fr.univamu.progav.cours.cours9;

import java.util.Random;

public class Roulette {

  private static final Random gen = new Random();

  // Déclaration d'une classe d'exception
  public static class ZeroException extends Exception {}

  // Cette méthode lève l'exception dans certains cas
  public int roll() throws ZeroException {
    int result = gen.nextInt(37);
    if (result == 0) {
      throw new ZeroException();
    }
    return result;
  }
}
