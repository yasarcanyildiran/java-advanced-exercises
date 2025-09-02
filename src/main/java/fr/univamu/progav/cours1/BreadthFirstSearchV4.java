package fr.univamu.progav.cours1;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearchV4 {

  // On extrait les deux tâches de la boucle 'while' en deux méthodes dédiées.
  public BreadthFirstSearchV4(Tree root) {
    List<Tree> currentLevel = new ArrayList<>();
    currentLevel.add(root);
    while (!currentLevel.isEmpty()) {
      printLevel(currentLevel);
      currentLevel = getNextLevel(currentLevel);
      System.out.println();
    }
  }

  private static List<Tree> getNextLevel(List<Tree> currentLevel) {
    List<Tree> nextLevel = new ArrayList<>();
    for (Tree tree : currentLevel) {
      addAllChildren(tree, nextLevel);
    }
    return nextLevel;
  }

  private static void printLevel(List<Tree> currentLevel) {
    for (Tree tree : currentLevel) {
      System.out.print(tree.getValue() + " ");
    }
  }

  private static void addAllChildren(Tree tree, List<Tree> level) {
    for (Tree child : tree.getChildren()) {
       level.add(child);
    }
  }

  // Conclusion :
  // chaque méthode contient une seule boucle, fait une seule chose, et
  // est bien nommée. C'est une solution satisfaisante.
}
