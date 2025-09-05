package fr.univamu.progav.cours.cours1;

import java.util.List;

public interface Tree {
  int getValue();
  List<Tree> getChildren();


  static Tree getSampleTree() {
    return node(8,
      node(12,
        node(5),
        node(16,
          node(7),
          node(17))),
      node(10,
        node(19),
        node(2,
          node(11),
          node(13))));
  }



  static Tree node(int content, Tree... children) {
    return new Tree() {
      @Override
      public int getValue() {
        return content;
      }

      @Override
      public List<Tree> getChildren() {
        return List.of(children);
      }
    };
  }

}
