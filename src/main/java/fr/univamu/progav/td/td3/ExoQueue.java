package fr.univamu.progav.td.td3;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 *  Une classe permettant d'évaluer des expressions arithmétiques entières en notation polonaise
 *  inverse, comme <em>3 5 2 * 1 + -4 7 + + *</em>. L'évaluation d'une telle expression se fait à
 *  l'aide d'une pile, et en lisant l'expression de gauche à droite :
 *  <ul>
 *    <li>3 : on empile 3, la pile est \([3]\)</li>
 *    <li>5 : on empile 5, la pile est \([3,5]\)</li>
 *    <li>2 : on empile 2, la pile est \([3,5,2]\)</li>
 *    <li>* : on remplace les deux éléments supérieurs par leur produit, la pile est \([3,10]\) </li>
 *    <li>1 : on empile 1, la pile est  \([3,10,1]\)</li>
 *    <li>+ : on remplace les deux éléments supérieurs par leur somme, la pile est  \([3,11]\)</li>
 *    <li>-4 : on empile -4, la pile est  \([3,11,-4]\)</li>
 *    <li>7 : on empile 7, la pile est  \([3,11,-4,7]\)</li>
 *    <li>+ : on remplace les deux éléments supérieurs par leur somme, la pile est  \([3,11,3]\) </li>
 *    <li>+ : on remplace les deux éléments supérieurs par leur somme, la pile est  \([3,14]\)</li>
 *    <li>* : on remplace les deux éléments supérieurs par leur produit, la pile est \([42]\)
 *    </li>
 *  </ul>
 *  Un des avantages de cette notation est l'absence de parenthèses, qui sont inutiles.
 */
public class ExoQueue {

  // TODO initialisée avec une pile vide
  private final Deque<Integer> intStack =null;


  /** Insère une valeur en haut de la pile.
   * @param value la valeur à insérer.
   */
  public void addValue(int value) {
    // TODO
    intStack.offerLast(value);
  }

  /**
   * Réalise l'addition des deux premiers éléments de la pile.
   */
  public void performAddition() {
    //TODO
  }

  /**
   * Réalise la multiplication des deux premiers éléments de la pile.
   */
  public void performMultiplication() {
    // TODO
  }

  /**
   * @return le nombre de valeurs dans la pile
   */
  public int nbRemainingValues() {
    // TODO
    return 0;
  }

  /**
   * @return la valeur en haut de la pile (<code>null</code> si la pile est vide)
   */
  public int topValue() {
    // TODO
    return 0;
  }

}
