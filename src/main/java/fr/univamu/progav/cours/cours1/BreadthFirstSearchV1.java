package fr.univamu.progav.cours.cours1;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearchV1 {

  // Méthode pour le parcours en largeur (par niveau) d'un arbre.
  // La méthode doit afficher chaque élément, de haut (la racine) en bas,
  // chaque niveau de gauche à droite.
  public BreadthFirstSearchV1(Tree root) {
    List<Tree> currentLevel = new ArrayList<>();
    currentLevel.add(root);
    while (!currentLevel.isEmpty()) {
      List<Tree> nextLevel = new ArrayList<>();
      for (Tree tree : currentLevel) {
        System.out.print(tree.getValue() + " ");
        for (Tree child : tree.getChildren()) {
           nextLevel.add(child);
        }
      }
      currentLevel = nextLevel;
      System.out.println();
    }
  }

  // Problème :
  // La méthode est difficile à comprendre
  // Solution proposée :
  // remplacer les boucles internes par des appels à de nouvelles méthodes

}
