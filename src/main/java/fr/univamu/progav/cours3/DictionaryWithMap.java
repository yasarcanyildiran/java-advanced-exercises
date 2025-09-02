package fr.univamu.progav.cours3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class DictionaryWithMap {

  // L'utilisation d'une 'Map' permet de mémoriser pour chaque mot, son
  // nombre occurrence. Ici les clés (uniques) sont de type 'String',
  // les valeurs associées sont de type 'Integer'.

  private final Map<String, Integer> words = new HashMap<>();
  private int count = 0;

  // On en profite pour améliorer la solution, pour ne compter que les
  // vrais mots. Un vrai mot est constitué de lettres et possiblement
  // du symbole '-'. On donne une expression régulière : '\\p{IsAlphabetic}'
  // représente toutes les lettres. '[-\\p{IsAlphabetic]' signifie une
  // occurrence de '-' ou d'une lettre. L'étoile dénote la multiplicité.
  // (cf cours d'automates et langages formels)

  public void fillWith(Scanner scanner) {
    while (scanner.hasNext()) {
      count++;
      String word = scanner.next();
      if (!word.matches("[-\\p{IsAlphabetic}]*")) continue;
      int occurences = words.getOrDefault(word, 0);
      words.put(word, occurences + 1);
    }
  }

  // On peut boucler sur toutes les entrées clé-valeur d'une Map.

  public Map.Entry<String,Integer> findMostFrequentWord() {
    Map.Entry<String,Integer> best = null;
    for (Map.Entry<String,Integer> entry : words.entrySet()) {
      if (best == null || entry.getValue() > best.getValue()) {
        best = entry;
      }
    }
    return best;
  }

  // On peut boucler uniquement sur les clés avec 'map.keySet()',
  // ou uniquement sur les valeurs avec 'map.getValues()'.

  public String findLongestWord() {
    String longest = "";
    for (String word : words.keySet()) {
      if (word.length() > longest.length()) {
        longest = word;
      }
    }
    return longest;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("src/main/resources/cyrano.txt"));
    DictionaryWithMap dict = new DictionaryWithMap();
    long start = System.nanoTime();
    dict.fillWith(scanner);
    long stop = System.nanoTime();
    System.out.println("Nombre de mots distincts : " + dict.words.size());
    System.out.println("Nombre de mots total : " + dict.count);
    System.out.println("Calculé en " + ((stop - start) / 1000000) + "ms.");
    System.out.println("Mot le plus long : " + dict.findLongestWord());
    Map.Entry<String,Integer> mostFrequentWord = dict.findMostFrequentWord();
    System.out.println(
      "Mot le plus fréquemment utilisé : " + mostFrequentWord.getKey()
        + " (" + mostFrequentWord.getValue() + ")");
  }


}
