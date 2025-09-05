package fr.univamu.progav.cours.cours1;

import java.util.Scanner;

public class InteractiveSumV3 {

  private final Scanner input;

  public InteractiveSumV3() {
    this.input = new Scanner(System.in);
  }

  public InteractiveSumV3(Scanner scanner) {
    this.input = scanner;
  }

  // le 'while(true)' signale clairement une boucle qui se
  // quitte par un 'break' ou 'return'. La condition est testée
  // juste avant de quitter la boucle.
  public void run() {
    System.out.println("Entrez des entiers (-1 pour terminer).");
    int sum = 0;
    while (true) {
      int value = input.nextInt();
      if (value == -1) break;
      sum = sum + value;
    }
    System.out.println("Somme = " + sum);
  }

  // Conclusion :
  // ordre naturel des instructions, pas de répétition.
  // Dans la version suivante, on change les règles :
  // 0 termine le programme,
  // les nombres négatifs doivent être ignorés.

}
