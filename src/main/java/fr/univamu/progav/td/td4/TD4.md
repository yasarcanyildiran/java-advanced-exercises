Cette semaine, les exercices consistent en créer des énumérations, 
enregistrements et interfaces scellés. Nous n'écrirons pas de méthode, donc 
il n'y a pas de test associé, ni de classes fournies. Un fois l'exercice 
fini, demandez à votre enseignant d'évaluer votre solution.

Introduction
============

Un atelier de céramistes d'Aubagne produit différents objets en terre cuite, et 
nous demande de réaliser une application pour gérer ses commandes. Pour cela nous 
devons représenter chaque objet pouvant être fabriqué. Il s'agit
1. d'escudelles, caractérisées par un diamètre (en centimètres);
2. de mazettes, existants en trois tailles (taille café, taille thé ou 
   taille chocolat);
3. de toupins, définis par une contenance en litres;
4. de poumié, avec un nombre arbitraire de pommes (généralement 3 ou 6).

De plus, chaque objet peut être fabriqué avec une couleur au choix, parmi :
1. Corail
2. Olive
3. Jaune de cobalt
4. Indigo
5. Chartreuse
6. Blanc lunaire
7. Céruléen


Exercice 1
==========

Créer un fichier `Color.java` et y définir une énumération pour représenter 
toutes les couleurs disponibles.

Exercice 2
==========

Définir une énumération pour les tailles des mazettes, dans un fichier 
`TailleMazette.java`.

Exercice 3
==========

Définir dans un fichier `Mazette.java`, un enregistrement pour représenter 
les mazettes.

Exercice 4
==========

Procéder de même pour définir des enregistrements pour représenter les 
escudelles, les toupins et les poumiés.

Exercice 5
==========

Créer une interface scellée `Product`, dans un fichier du même nom. Un 
produit peut-être l'un des quatre proposés. Assurez-vous que chaque produit 
possède bien une couleur.



