package fr.univamu.progav.cours.cours6;

public class PrintCollection {


  // Voici deux fonctions presque identiques.

  public static String writeInts(int[] ints) {
    boolean isFirst = true;
    StringBuilder builder = new StringBuilder();
    for (int i : ints) {
      if (isFirst) { isFirst = false; }
      else { builder.append(", "); }
      builder.append(i);
    }
    return builder.toString();
  }


  public static String writeStrings(String[] strings) {
    boolean isFirst = true;
    StringBuilder builder = new StringBuilder();
    for (String str : strings) {
      if (isFirst) { isFirst = false; }
      else { builder.append(", "); }
      builder.append(str);
    }
    return builder.toString();
  }

  // Peut-on les factoriser ?
  // On repère les comportements identiques et distincts, et on
  // fait une interface pour les comportements distincts.

  // Problème :
  // il n'y a pas de comportement distinct ! seuls les types diffèrent

  // Solution : abstraire les types distincts, ici en un type générique T

  public static <T> String write(T[] values) {
    boolean isFirst = true;
    StringBuilder builder = new StringBuilder();
    for (T t : values) {
      if (isFirst) { isFirst = false; }
      else { builder.append(", "); }
      builder.append(t);
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    int[] ints = { 1,2,3 };
    String[] strings = { "foo", "bar", "baz"};
    writeInts(ints);
    writeStrings(strings);
    // write(ints); // Non, car int est un type primitif, T abstrait les types références
    write(strings);
  }

  // Seule solution pour int[] : surcharger en write(int[] values).
  // Peu satisfaisant, c'est une raison d'éviter d'utiliser les tableaux
  // en java, sauf quand les performances l'exigent.

}
