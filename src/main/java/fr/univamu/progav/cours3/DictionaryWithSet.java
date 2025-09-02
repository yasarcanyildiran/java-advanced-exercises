package fr.univamu.progav.cours3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DictionaryWithSet {

  private final Set<String> words = new HashSet<>();
  private int count = 0;

  // En utilisant 'Set', l'unicité est garantie, il n'y a plus besoin
  // de tester si le mot est déjà présent. 'contains' serait néanmoins
  // beaucoup plus efficace qu'avec une liste.

  public void fillWith(Scanner scanner) {
    while (scanner.hasNext()) {
      count++;
      words.add(scanner.next());
    }
  }

  public String findLongestWord() {
    String longest = "";
    for (String word : words) {
      if (word.length() > longest.length()) {
        longest = word;
      }
    }
    return longest;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("src/main/resources/cyrano.txt"));
    DictionaryWithSet dict = new DictionaryWithSet();
    long start = System.nanoTime();
    dict.fillWith(scanner);
    long stop = System.nanoTime();
    System.out.println("Nombre de mots distincts : " + dict.words.size());
    System.out.println("Nombre de mots total : " + dict.count);
    System.out.println("Calculé en " + ((stop - start) / 1000000) + "ms.");
  }

  // Conclusion :
  // pour stocker des données uniques, avec des opérations
  // d'insertion/suppression/test d'appartenance rapides, 'Set' est
  // le bon choix.
  // Si on veut compter le nombre d'occurences de chaque mot,
  // on utilise 'Map', qui permet en plus de 'Set' d'associer une valeur
  // à chaque élément.

}
