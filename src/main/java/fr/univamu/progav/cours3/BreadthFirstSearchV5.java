package fr.univamu.progav.cours3;

import fr.univamu.progav.cours1.Tree;

import java.util.ArrayDeque;
import java.util.Deque;


public class BreadthFirstSearchV5 {

  // Une version du parcours en large en utilisant une file, et un élément
  // spécial pour marquer la fin d'un niveau.

  private static final Tree END_OF_LEVEL = Tree.node(0);

  public BreadthFirstSearchV5(Tree root) {
    Deque<Tree> waitingList = new ArrayDeque<>();
    waitingList.offerLast(root);
    waitingList.offerLast(END_OF_LEVEL);
    while (true) {
      Tree currentTree = waitingList.pollFirst();
      if (waitingList.isEmpty()) break;
      if (currentTree == END_OF_LEVEL) {
        System.out.println();
        waitingList.offerLast(END_OF_LEVEL);
        continue;
      }
      System.out.print(currentTree.getValue() + " ");
      enqueueChildren(currentTree, waitingList);
    }
  }

  private static void enqueueChildren(Tree next, Deque<Tree> waitingList) {
    for (Tree child : next.getChildren()) {
      waitingList.offerLast(child);
    }
  }

  public static void main(String[] args) {
    Tree t = Tree.getSampleTree();
    new BreadthFirstSearchV5(t);
  }
}
