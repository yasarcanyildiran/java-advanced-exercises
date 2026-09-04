package fr.univamu.progav.td.td1.mock;

import fr.univamu.progav.td.td1.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class MockTree implements BreadthFirstSearch.Tree {


  public static final BreadthFirstSearch.Tree tree0 =
    of(0,of(1),of(2),of(3),of(4));
  public static final BreadthFirstSearch.Tree tree1 =
    of(1,
      of(2,
        of(3,
          of(4)),
        of(5,
          of(6))),
      of(7,
        of(8),
        of(9)));

  public List<BreadthFirstSearch.Tree> getChildren() {
    return children;
  }

  public int getValue() {
    return value;
  }
  public static MockTree of(int value, BreadthFirstSearch.Tree... children) {
    MockTree tree = new MockTree(value);
    for (BreadthFirstSearch.Tree child : children) {
      tree.addChild(child);
    }
    return tree;
  }
  private List<BreadthFirstSearch.Tree> children = new ArrayList<>();
  private int value;

  private MockTree(int value) {
    this.value = value;
  }

  public void addChild(BreadthFirstSearch.Tree child) {
    children.add(child);
  }




}
