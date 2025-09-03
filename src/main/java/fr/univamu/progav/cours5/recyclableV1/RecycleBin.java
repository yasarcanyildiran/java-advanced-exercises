package fr.univamu.progav.cours5.recyclableV1;

import java.util.HashSet;
import java.util.Set;

public class RecycleBin {
  private Set<Object> trash = new HashSet<>() ;

  public void add(Object obj) {
     trash.add(obj);
  }

  public void empty() {
    for (Object obj : trash) {
      if (obj instanceof Can can) can.recycle();
      if (obj instanceof GlassBottle bottle) bottle.recycle();
      if (obj instanceof CardBoard board) board.recycle();
      if (obj instanceof Paper paper) paper.recycle();
    }
  }

  // Problème :
  // pas de type adapté pour les déchets recyclables
  // Ici on utilise le type Object.
  // Si on le change par 'Cardboard', on ne pourra pas jeter des 'GlassBottle'
  // et inversement.
  // Dans cette solution, on peut jeter n'importe quel déchet,
  // même non recyclable.
  // Le type Object ne convient pas car il n'a pas de méthode de recyclage.
  // On est obligé de tester des instanciations : compliqué, et oblige
  // à changer la méthode empty() si on ajoute une nouvelle classe recyclable.
  // Solution :
  // Créer un type commun pour tous les déchets recyclables -> interface
  // Lui attribuer la méthode 'recycle'
}
