package fr.univamu.progav.cours5.recyclableV2;

import java.util.*;

public class RecycleBin {
  private Set<Recyclable> trash = new HashSet<>() ;

  public void add(Recyclable obj) {
     trash.add(obj);
  }

  public void empty() {
    for (Recyclable obj : trash) {
       obj.recycle();
    }
  }


  public static void main(String[] args) {
    // On vérifie le bon comportement de la solution
    Paper item1 = new Paper(21,29.7); // OK
    Recyclable item2 = new Paper(10,8); // OK
//    Paper item3 = item2; // Non, l'information "item2 contient du papier" est perdue.
//    Recyclable item4 = new Recyclable(); // Non, Recyclable est une interface donc n'est pas instanciable
//    Paper item5 = new Can(); // Non, une canette n'est pas du papier
    RecycleBin trash = new RecycleBin();
    trash.add(item1); // OK
    trash.add(item2); // OK
    trash.add(new Paper(5,5)); // OK
    trash.add(new Can(0.33)); // OK
    trash.empty();

    // Interaction avec les collections
    List<Recyclable> recyclables = new ArrayList<>();
    recyclables.add(item1); // OK
    recyclables.add(item2); // OK
    List<Paper> papers = new ArrayList<>();
    papers.add(item1); // OK
    // papers.add(item2); // Non, l'information "item2 contient du papier" est perdue.


    // list = papers; // Non, une liste de papiers n'est pas une liste de recyclables
    // papers = list; // Non, une liste de recyclables n'est pas une liste de papiers
  }

  // Règle de typage :
  // c'est le type d'une variable, et non son contenu, qui détermine COMMENT
  // la variable peut être utilisée
  // c'est le contenu, et non le type de la variable, qui détermine l'EFFET
  // de l'utilisation de la variable.
  // (les types existent à la compilation, mais pas à l'exécution du progamme)

}
