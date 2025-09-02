package fr.univamu.progav.cours1;

import java.util.Scanner;

public class InteractiveSumV1 {

  private final Scanner input;

  public InteractiveSumV1() {
    this.input = new Scanner(System.in);
  }

  public InteractiveSumV1(Scanner scanner) {
    this.input = scanner;
  }

  // Sommer tous les entiers lisibles jusqu'à lire l'entier -1,
  // auquel cas on s'arrête.
  public void run() {
    System.out.println("Entrez des entiers (-1 pour terminer).");
    int sum = 0;
    boolean isNotOver = true;
    while (isNotOver) {
      int value = input.nextInt();
      if (value == -1) {
        isNotOver = false;
      } else {
        sum = sum + value;
      }
    }
    System.out.println("Somme = " + sum);
  }

  // Problème :
  // l'utilisation d'une variable booléenne pour contrôler la terminaison de
  // la boucle est peu lisible (séparation entre le 'while' qui décide de la continuation, et le
  // 'if' qui effectue le test de continuation).
  // Solution :
  // déplacer le test d'égalité directement dans la condition du 'while'.
}
