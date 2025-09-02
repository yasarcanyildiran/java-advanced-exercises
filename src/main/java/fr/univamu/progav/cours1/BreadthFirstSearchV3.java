package fr.univamu.progav.cours1;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearchV3 {

  // la boucle interne 'for' fait deux choses :
  // - afficher les éléments du niveau;
  // - préparer le prochain niveau.
  // La prochaine étape de refactoring consiste à séparer
  // les deux fonctionnalités, pour que chacune soit gérée par sa propre boucle.
  // Cela permettra l'extraction de deux méthodes ensuite.
  public BreadthFirstSearchV3(Tree root) {
    List<Tree> currentLevel = new ArrayList<>();
    currentLevel.add(root);
    while (!currentLevel.isEmpty()) {
      // Affichage des éléments du niveau
      for (Tree tree : currentLevel) {
        System.out.print(tree.getValue() + " ");
      }
      // Préparation du prochain niveau
      List<Tree> nextLevel = new ArrayList<>();
      for (Tree tree : currentLevel) {
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
  // le constructeur est trop complexe.
  // Solution :
  // On extrait le contenu du 'while' dans deux nouvelles méthodes.

}
