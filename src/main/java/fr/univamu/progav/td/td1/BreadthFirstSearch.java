package fr.univamu.progav.td.td1;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {

  public interface Tree {
    int getValue();
    List<Tree> getChildren();
  }

  private List<Integer> orderedValue = new ArrayList<>();

  public  BreadthFirstSearch(Tree root) {
    List<Tree> currentLevel = new ArrayList<>();
    currentLevel.add(root);
    while (!currentLevel.isEmpty()) {
      List<Tree> nextLevel = new ArrayList<>();
      for (Tree tree : currentLevel) {
        orderedValue.add(tree.getValue());
        for (Tree child : tree.getChildren()) {
           nextLevel.add(child);
        }
      }
      currentLevel = nextLevel;
    }
  }

  public List<Integer> getOrderedValue() {
    return orderedValue;
  }
}
