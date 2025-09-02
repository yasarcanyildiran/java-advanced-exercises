package fr.univamu.progav.cours3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class DictionaryWithList {

  // On souhaite compter le nombre de mots distincts d'un roman. Il faut
  // stocker tous les mots vus au moins une fois. Voici une solution
  // à base de liste. Il faut s'assurer qu'un mot n'est pas ajouté deux fois
  // dans la liste.

  private final List<String> words = new ArrayList<>();
  private int count = 0;

  public void fillWith(Scanner scanner) {
    while (scanner.hasNext()) {
      count++;
      String word = scanner.next();
      if (words.contains(word)) continue;
      words.add(word);
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
    DictionaryWithList dict = new DictionaryWithList();
    long start = System.nanoTime();
    dict.fillWith(scanner);
    long stop = System.nanoTime();
    System.out.println("Nombre de mots distincts : " + dict.words.size());
    System.out.println("Nombre de mots total : " + dict.count);
    System.out.println("Calculé en " + ((stop - start) / 1000000) + "ms.");
  }


  // Problème :
  // c'est lent !
  // Solution :
  // 'List' n'est pas optimisé pour que 'contains' soit rapide. Pour cela,
  // il faut utiliser 'Set'

}
