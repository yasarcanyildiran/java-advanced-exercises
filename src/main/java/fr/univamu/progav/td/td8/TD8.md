Exercice
========

Compléter les méthodes de la classe `ExercicesStream`.

Vous devez utiliser des Stream. Il est interdit d'utiliser des boucles ou 
des récursions. Il est interdit de convertir les streams en listes (sauf 
pour calculer la liste à retourner dans la méthode ```males```). Toutes 
les méthodes doivent avoir une seule instruction, l'instruction ```return```.

La dernière méthode est la plus difficile, elle demande de construire un 
collecteur à partir de trois éléments :
- un ```Supplier<R>```, ```R``` étant le type des objets effectuant la 
  collection, disons un collecteur. Ce ```Supplier``` permet de créer un 
  nouveau collecteur; 
- un ```BiConsumer<R,People>```, qui est une fonction prenant un collecteur 
  et une personne collectée. C'est en général la méthode du collecteur 
  chargé d'accepter les personnes collectées l'une après l'autre. Le 
  collecteur met à jour son état interne pour tenir compte de la personne 
  collectée.
- un ```BiConsumer<R,R>```, qui est une fonction permettant de fusionner le 
  travail de deux collecteurs. Le premier collecteur agrège les données 
  récoltées par le deuxième collecteur dans son état interne.

Pour nous, le collecteur est un objet calculant le nombre de personnes de 
chaque sexe. Le premier argument sera donc son constructeur, le deuxième 
sera sa méthode ```add```, et le troisième sa méthode ```merge```, chacun 
pouvant être donné par une référence de méthode. Une fois le collecteur 
effectué, il reste à utiliser la méthode ```areEquals()``` pour déterminer 
si le nombre de femmes est égal au nombre d'hommes.

Tous les tests de ```ExercicesStreamTest``` doivent passer à la fin de 
l'exercice.