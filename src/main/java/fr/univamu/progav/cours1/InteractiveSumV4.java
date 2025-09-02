package fr.univamu.progav.cours1;

import java.util.Scanner;

public class InteractiveSumV4 {

  private final Scanner input;

  public InteractiveSumV4() {
    this.input = new Scanner(System.in);
  }

  public InteractiveSumV4(Scanner scanner) {
    this.input = scanner;
  }

  // On modifie la règle : on somme les positifs et on s'arrête à 0.
  // On utilise 'continue' pour passer à l'itération suivante. Si 'value' est
  // négatif, l'affectation à 'sum' est ainsi sautée.
  public void run() {
    System.out.println("Entrez des entiers (-1 pour terminer).");
    int sum = 0;
    while (true) {
      int value = input.nextInt();
      if (value == 0) break;
      if (value < 0) continue;
      sum = sum + value;
    }
    System.out.println("Somme = " + sum);
  }

  // Conclusion :
  // cette solution est un peu plus simple que d'avoir mis
  // l'affectation 'sum = sum + value' dans un 'if'. On met en valeur que
  // le comportement normal est de sommer les valeurs, et que la règle de
  // sauter les négatifs est une exception.

}
