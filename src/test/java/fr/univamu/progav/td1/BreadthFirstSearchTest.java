package fr.univamu.progav.td1;

import fr.univamu.progav.td1.mock.MockTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

  @Test
  void searchTree0() {
    List<Integer> bfsOrder =
      new BreadthFirstSearch(MockTree.tree0).getOrderedValue();
    assertEquals(List.of(0,1,2,3,4), bfsOrder);
  }


  @Test
  void searchTree1() {
    List<Integer> bfsOrder =
      new BreadthFirstSearch(MockTree.tree1).getOrderedValue();
    assertEquals(List.of(1,2,7,3,5,8,9,4,6), bfsOrder);
  }

  @Test
  void searchLeaf() {
    List<Integer> bfsOrder = new BreadthFirstSearch(MockTree.of(2)).getOrderedValue();
    assertEquals(List.of(2), bfsOrder);
  }
}