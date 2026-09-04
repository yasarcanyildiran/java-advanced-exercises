Cette semaine les exercices portent sur les classes anonymes, les lambdas et 
les références de méthodes.


Exercice 1
==========

Compléter la classe ```Interval``` qui représente des ensembles d'entiers 
consécutifs, comme $\{3,4,5,6,7\}$.

Pour la méthode ```iterator```, compléter la classe anonyme. Il faudra 
ajouter une propriété pour retenir le prochain entier de l'itération. 

Vérifier votre travail avec les tests de la classe ```IntervalTest```.

Exercice 2
==========

Une ```Sequence<T>``` ressemble à une ```List<T>```, mais on ne nous donne 
que des méthodes nécessitant un argument fonctionnel.

- ```forEach``` demande un ```Consumer<T>```, une action qui sera appliquée 
  à chaque élément de la séquence. L'interface ```Consumer<T>``` est définie 
  par 
```java
interface Consumer<T> {
  void accept(T value);
}
```
- ```anyMatch``` demande un ```Predicate<T>```, un prédicat pouvant être 
  appliqué aux éléments de la séquence. ```anyMatch``` renvoie ```true``` si au 
  moins un des éléments de la séquence satisfait le prédicat. L'interface 
  ```Predicate<T>``` est définie par
```java
interface Predicate<T> {
  boolean test(T value);
}
```
- ```maximum``` demande un ```Comparator<T>```, un objet capable de décider 
  quel est la plus grande de 2 valeurs de type ```T```. L'interface 
  ```Comparator<T>``` est définie par 
```java
interface Comparator<T> {
  int compare(T t1, T t2);
}
```

Compléter les méthodes statiques de la classe ```IntervalSequence```. Pour 
cela :

- pour ```containsEmptyInterval```, utiliser une référence de méthode pour 
  définir le prédicat "est vide" des intervalles.
- Pour ```sumOfSizes```, essayer d'utiliser une lambda avec un compteur 
  de type ```int```. Cela ne va pas fonctionner, pourquoi ? 
- Introduire une interface correspondant à un compteur entier :
```java
  interface IntCounter {
    void add(int value);
    int get();
  }
```
- Dans ```sumOfSizes```, créer un compteur à l'aide d'une classe anonyme, 
  puis utiliser ```forEach``` sur la séquence avec une lambda pour augmenter 
  le compteur.
- Dans ```longestInterval```, utiliser une lambdas.
- Vérifier votre travail avec les tests de la classe 
  ```IntervalSequencesTest```.


