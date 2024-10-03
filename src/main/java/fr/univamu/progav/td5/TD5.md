Dans cet exercice, nous implémentons le comportement de trois personnages, le 
guerrier, le mage et le prêtre, dans un jeu de rôle. Chacun peut donner et 
recevoir des coups, a des points de vie et meurt lorsque ses points de vie 
deviennent négatifs. Par contre, ils réagissent différemment aux coups, ont des 
attaques différentes et ont chacun une action spéciale spécifique.

Les coups sont décrits par la classe `Blow`, chaque coup ayant une 
composante *dommage physique* et une composante *dommage magique*.
Chaque point de dommage, physique ou magique, fait baisser d'un point la vie 
du personnage recevant le coup.

Le guerrier
-----------

- Ses attaques sont physiques : 3 points physiques et 0 point magique.
- Il est costaud : il ne subit que la moitié des dommages physiques des 
  coups qu'il reçoit.
- Il peut entrer en rage avec son action spéciale. Sa rage lui permet de 
  frapper deux fois plus fort pendant 3 attaques (6 dommages physiques).
- Après 3 attaques, il perd sa rage.
- S'il reçoit un coup provoquant une perte d'au moins 5 points de vie 
  pendant sa rage, sa rage dure une attaque supplémentaire.

Le mage
-------

- Ses attaques sont magiques : 4 points magiques et 0 points physique.
- Il absorbe la magie : s'il reçoit un coup, il ne perd pas de vie à cause 
  des dommages magiques, au contraire, la moitié des dommages magiques du 
  coup s'annule avec les dommages physiques (par exemple, pour 5 dommages 
  physiques et 3 magiques, il ne perd que 5 - (3/2) = 4 points de vie).
- L'absorption de magie ne lui permet pas de gagner des points de vie 
  (seulement de réduire les dommages physiques).
- Son action spéciale consiste à invoquer un bouclier magique, qui absorbe 
  les dommages physiques, jusqu'à 8 points. Le bouclier disparait une fois 
  qu'il a absorbé 8 points au total (par exemple après deux attaques faisant 
  5 dommages physiques chacune, il laissera passer 2 dommages physiques lors 
  de la deuxième attaque).
- Le bouclier est appliqué avant la règle de l'absorption des dommages magiques.


Le prêtre
---------

- Ses attaques combinent force (2 dommages physiques) et esprit (1 dommage 
  magique).
- Son action spéciale est de prier.
- Toutes les 3 prières, il est exaucé : il récupère 10 points de vie, et sa 
  prochaine attaque provoque 5 dommages magiques supplémentaires. 


Travail à faire
---------------

1. Compléter l'implémentation du guerrier et de la classe abstraite `Character`.
2. Vérifier votre travail avec les tests du guerrier.
3. Compléter l'implémentation du mage, jusqu'à passage réussi des tests.
4. Créer la classe du prêtre tel que décrit.