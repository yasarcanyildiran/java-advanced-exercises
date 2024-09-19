package fr.univamu.progav.td3;

public class ExoArray {

  /** Initialise un tableau d'entiers, la cellule d'indice \(i\) contient l'entier \(i\), sauf une
   * cellule sur trois depuis l'indice 1, qui contiennent \(-i\). Ainsi le tableau commence par
   * <code>{0,-1,2,3,-4,5,6,-7,...}</code>.
   * @param size la longueur souhaitée du tableau
   * @return le tableau d'entiers
   */
  public static int[] initArray(int size) {
    // TODO
    return null;
  }

  /** Calcule la somme des entiers en position paire dans un tableau.
   * Par exemple pour <code>{1,3,2,4}</code> le résultat est \(3 = 1 + 2\).
   * @param array le tableau dont on somme les entiers en position paire.
   * @return la somme des entiers en position paire.
   */
  public static int sumEvenPositions(int[] array) {
    // TODO
    return 0;
  }

  /** Décale tous les éléments du tableau "vers la gauche", sauf l'élément d'indice 0 qui est
   * replacé en fin de tableau. Par exemple pour <code>{1,4,2,3}</code>, le tableau devient
   * <code>{4,2,3,1}</code>.
   * @param array le tableau à modifier.
   */
  public static void shiftToLeft(int[] array) {
    // TODO
  }
}
