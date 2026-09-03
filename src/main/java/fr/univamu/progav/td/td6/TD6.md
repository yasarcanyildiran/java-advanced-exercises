Ces exercices ont pour sujet une interface `Lens` générique, permettant 
de représenter un emplacement mémoire autorisant la lecture et l'écriture.

Prendre connaissance de cette interface, qui propose deux méthodes `set`
et `get`.


Exercice 1
==========

Rendre la classe `Box` générique. Pour l'instant elle implémente un 
`Lens<Integer>`, mais nous voulons l'utiliser avec d'autres types.

Modifier la méthode de test `genericTest` de la classe `BoxTest` pour qu'elle 
fonctionne.

Exercice 2
==========

Étant donné une liste, chaque case de la liste est accessible en lecture et 
en écriture. Il est donc possible de décrire chaque case avec l'interface 
`Lens`. Compléter la classe générique `ListCellLens`, prenant une liste et 
l'indice d'une case en paramètre du constructeur, et représentant la case ainsi 
désignée.

Vérifiez votre travail à l'aide des tests `ListCellLensTest` associés à la 
classe.

Exercice 3
==========

Nous pouvons faire la même chose avec les tableaux. Compléter la classe 
générique `ArrayCellLens`, prenant un tableau et
l'indice d'une case en paramètre du constructeur, et représentant la case ainsi
désignée.

Vérifiez votre travail à l'aide des tests `ArrayCellLensTest` associés à la 
classe.

Exercice 4
==========

Si vous essayez d'utiliser `ArrayCellLens` avec un tableau de type `int[]`, 
cela produit une erreur à la compilation. Pourquoi ?

Ajouter une classe `IntArrayCellLens` pour pouvoir faire un `Lens` sur une 
case d'un tableau de type `int[]`.

Ajouter un test dans la classe `ArrayCellLensTest`, s'assurant du bon 
fonctionnement des méthodes `set` et `get` pour une case d'un tableau de 
type `int[]`

Exercice 5 (Optionnel)
======================

Nous pouvons utiliser un objet de type `Lens` pour stocker une valeur sous 
un format compressé. Pour un type `S` (dont les valeurs prennent beaucoup de 
place), si nous disposons d'une fonction de compression `f` vers un type `T` 
(nécessitant moins de place), et de son inverse `g`, nous pouvons 
représenter une valeur `s` de type `S` en stockant uniquement `f(s)`. La 
méthode `get` applique automatiquement `g` pour retrouver la valeur initiale 
(de type `S`). La méthode `set` applique automatiquement `f` pour ne stocker 
qu'une image (de type `T`). Ainsi, nous réduisons l'espace utilisé, en 
échange d'un coût de calcul des fonctions `f` et `g` à chaque opération.

Ajouter une interface `Bijection` permettant de représenter par deux 
méthodes les fonctions `f` et `g`.

Ensuite créer une classe `ConvertingLens`, de type `Lens<S>`, et ayant une 
propriété de type `T`. Le constructeur sera paramétré par la bijection à 
utiliser.

Tester avec `S = String`, `T = Integer`, en se restreignant aux chaînes de 
caractères correspondant à des nombres décimaux (comme `"129873"`)
