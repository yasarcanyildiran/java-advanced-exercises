Ce fichier donnes les instructions pour le TD1. Il est au format markdown, permettant d'éditer du texte avec des instructions de formattage simples. Pour le lire, il est préférable d'activer la visualisation du document formatté, sous VS Code avec le raccourci clavier `Control Shift V`.

Les tests de ce TD peuvent être évalués avec la commande `./gradlew td1Test`.

Si ce n'est pas déjà fait, installer l'extension `Error Lens` de Visual Studio Code.

Exercice 1
==========

Ouvrir la classe `ExercicesConditionnelle`, qui comprend 4 questions. Pour 
chaque question compléter la méthode correspondante. Tester que votre 
solution est correcte en utilisant les tests unitaires fournis (`./gradlew  td1test --tests ExercicesConditionnelleTest`).


Exercice 2
==========

Ouvrir la classe `ExercicesBoucles`, qui comprend 11 questions. Pour chaque 
question, compléter la méthode correspondante. Tester que votre solution est 
correcte en utilisant les tests unitaires fournis (`./gradlew td1test --tests ExercicesBouclesTest`).

Exercice 3
==========

Refactoriser la méthode `search` de la classe `BreadthFirstSearch` en 
extrayant les boucles internes en méthodes.

Les tests doivent toujours passés après vos modifications.


Exercice 4
==========

Refactoriser la méthode `primes` de la classe `Primes`, en extrayant la 
boucle interne et en simplifiant autant que possible.



