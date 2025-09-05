package fr.univamu.progav.td.td1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicesBoucles {

  public interface Person {
    int age();
    String name();
    boolean isFemale();
    Person mother();
    Person father();
    List<Person> children();
  }

  // Exercice : compléter toutes les méthodes suivantes



  public static boolean hasFemale(List<Person> persons) {
    return false;
  }


  // retourne vrai si la liste contient un individu homme et mineur (moins de 18 ans)
  public static boolean containsMinorMale(List<Person> persons) {
    return false;
  }


  // retourne un individu de la liste, femme et ayant au moins un enfant,
  // null si aucun individu ne convient
  public static Person findMother(List<Person> persons) {
    return null;
  }


  // retourne vrai si tous les individus de la liste sont majeurs (âge >= 18)
  public static boolean areAllMajor(List<Person> persons) {
    return false;
  }


  // trouve un individu de la liste ayant un enfant, et retourne l'âge
  // de cet enfant, ou -1 si aucun individu n'a d'enfant.
  public static int ageOfSomeChild(List<Person> persons) {
    return 0;
  }


  // retourne la liste de tous les hommes de la liste
  public static List<Person> males(List<Person> persons) {
    return List.of();
  }


  // retourne le nombre de femmes de la liste
  public static int nbFemales(List<Person> persons) {
    return 0;
  }


  // retourne la personne la plus agée de la liste,
  // null si la liste est vide
  public static Person eldest(List<Person> persons) {
    return null;
  }


  // retourne une chaîne de caractères, comprenant les noms de toutes les
  // personnes de la liste, dans l'ordre, séparés par une espace.
  public static String names(List<Person> persons) {
    StringBuilder builder = new StringBuilder();
    builder.append("Ceci est ajouté");
    builder.append(" en fin de chaîne.");
    return builder.toString(); // -> "Ceci est ajouté en fin de chaîne."
  }


  // retourne vrai si les nombres d'hommes et de femmes sont égaux.
  public static boolean hasAsManyMalesAsFemales(List<Person> persons) {
    return false;
  }

  // retourne l'âge moyen des individus de la liste (0 si la liste est vide)
  public static double averageAge(List<Person> persons) {
    return 0;
  }
}
