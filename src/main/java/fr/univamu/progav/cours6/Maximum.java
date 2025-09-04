package fr.univamu.progav.cours6;

import java.security.InvalidParameterException;
import java.util.List;

public class Maximum {
  
  // On souhaite calculer le maximum d'une liste. 
  // Le type des éléments est quelconque, on effectue la comparaison 
  // avec la méthode compareTo
  
  public static String maximumString(List<String> elements) {
    if (elements.isEmpty()) {
      throw new InvalidParameterException("maximum of empty list");
    }
    String max = elements.getFirst();
    for (String element : elements) {
      if (element.compareTo(max) > 0) {
        max = element;
      }
    }
    return max;
  }
  
  // Il faut donc introduire un type générique 'T',
  // et remplacer 'String' par 'T' partout.
  // Problème :
  // 'compareTo' n'est pas une méthode possédée par tout type 'T'
  // Solution :
  // ajouter une restriction d'interface au type générique 'T' avec 'extends'

  public static <T extends Comparable<T>> T maximum(List<T> elements) {
    if (elements.isEmpty()) {
      throw new InvalidParameterException("maximum of empty list");
    }
    T max = elements.getFirst();
    for (T element : elements) {
      if (element.compareTo(max) > 0) {
        max = element;
      }
    }
    return max;
  }


  public static void main(String[] args) {
    List<String> words = List.of("foo", "bar", "baz");
    List<Integer> ints = List.of(1, 3, 2);
    System.out.println(maximumString(words));
    System.out.println(maximum(ints));
    System.out.println(maximum(words));

  }
}
