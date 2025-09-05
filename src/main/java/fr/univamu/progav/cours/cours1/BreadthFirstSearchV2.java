package fr.univamu.progav.cours.cours1;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearchV2 {

  // extraction de la boucle la plus imbriquée, qui devient la méthode addAllChildren
  public BreadthFirstSearchV2(Tree root) {
    List<Tree> currentLevel = new ArrayList<>();
    currentLevel.add(root);
    while (!currentLevel.isEmpty()) {
      List<Tree> nextLevel = new ArrayList<>();
      for (Tree tree : currentLevel) {
        System.out.print(tree.getValue() + " ");
        addAllChildren(tree, nextLevel);
      }
      currentLevel = nextLevel;
      System.out.println();
    }
  }

  private static void addAllChildren(Tree tree, List<Tree> nextLevel) {
    for (Tree child : tree.getChildren()) {
       nextLevel.add(child);
    }
  }


  // Problème :
  // on peut extraire la boucle 'for' sur 'tree', mais cela donne
  // une méthode difficile à nommer ('displayCurrentLevelAndComputeNextLevel' ?)
  // Solution :
  // Séparer la boucle en deux boucles, une pour l'affichage, une pour le calcul
  // du niveau suivant.
}
