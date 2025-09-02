package fr.univamu.progav.cours1;

import java.util.Scanner;

public class InteractiveSumV2 {

  private final Scanner input;

  public InteractiveSumV2() {
    this.input = new Scanner(System.in);
  }

  public InteractiveSumV2(Scanner scanner) {
    this.input = scanner;
  }

  // Suppression de la variable booléenne contrôlant la terminaison de la boucle.
  // On teste directement 'value', mais il faut l'initialiser avant le 1er test.
  public void run() {
    System.out.println("Entrez des entiers (-1 pour terminer).");
    int sum = 0;
    int value = input.nextInt();
    while (value != -1) {
      sum = sum + value;
      value = input.nextInt();
    }
    System.out.println("Somme = " + sum);
  }

  // Problème :
  // l'affectation 'value = input.nextInt()' est répétée.
  // Solution :
  // privilégier l'usage de 'break' pour quitter une boucle en cours d'itération.

}
