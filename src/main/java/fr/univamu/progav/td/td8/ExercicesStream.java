package fr.univamu.progav.td.td8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ExercicesStream {

  public interface Person {
    int age();
    String name();
    boolean isFemale();
    Person mother();
    Person father();
    List<Person> children();
  }

  // Exercice : compléter toutes les méthodes suivantes


  // retourne vrai si la stream contient une femme
  public static boolean hasFemale(Stream<Person> persons) {
    // TODO
    return false;
  }


  // retourne vrai si la stream contient un individu homme et mineur (moins de 18 ans)
  public static boolean containsMinorMale(Stream<Person> persons) {
    // TODO
    return false;
  }


  // retourne un individu de la stream, femme et ayant au moins un enfant,
  // null si aucun individu ne convient
  public static Optional<Person> findMother(Stream<Person> persons) {
    // TODO
    return Optional.empty();
  }


  // retourne vrai si tous les individus de la stream sont majeurs (âge >= 18)
  public static boolean areAllMajor(Stream<Person> persons) {
    // TODO
    return false;
  }


  // retourne la liste de tous les hommes de la stream.
  public static List<Person> males(Stream<Person> persons) {
    // TODO
    return List.of();
  }


  // retourne le nombre de femmes de la stream
  public static long nbFemales(Stream<Person> persons) {
    // TODO
    return 0L;
  }

  // trouve un individu de la stream ayant un enfant, et retourne l'âge
  // de cet enfant.
  public static Optional<Integer> ageOfSomeChild(Stream<Person> persons) {
    // TODO
    return Optional.empty();
  }


  // retourne la personne la plus agée de la stream,
  public static Optional<Person> eldest(Stream<Person> persons) {
    // TODO
    return Optional.empty();
  }


  // retourne une chaîne de caractères, comprenant les noms de toutes les
  // personnes de la stream, dans l'ordre, séparés par une espace.
  public static String names(Stream<Person> persons) {
    // TODO
    return "";
  }


  // retourne l'âge moyen des individus de la stream
  public static OptionalDouble averageAge(Stream<Person> persons) {
    // TODO
    return OptionalDouble.empty();
  }


  private static class SexCount {
    // TODO ajouter des propriétés pour compter le nombre d'hommes et de femmes
    SexCount() {}

    void add(Person p) {
      // TODO dénombrer p dans les statistiques
    }

    void merge(SexCount count) {
      // TODO fusionner les statistiques
    }

    boolean areEquals() {
      // TODO renvoyer vrai si les nombres de femmes et d'hommes sont égaux
      return false;
    }
  }
  // retourne vrai si les nombres d'hommes et de femmes sont égaux.
  public static boolean hasAsManyMalesAsFemales(Stream<Person> persons) {
    Supplier<SexCount> supplier = null; // TODO initialiser les 3 variables.
    BiConsumer<SexCount, Person> accumulator = null;
    BiConsumer<SexCount,SexCount> combiner = null;
    return persons
      .collect(supplier,accumulator,combiner)
      .areEquals();
  }
}
