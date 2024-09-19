Introduction
============

Dans les exercices suivants, chaque petit programme comporte une 
erreur, qui 
apparait lors du test. L'objectif est d'apprendre à utiliser le débugger 
pour Java d'IntelliJ pour trouver la cause de l'erreur, et la corriger.

La tâche Gradle permet de lancer les tests, mais on préfèrera cette fois 
lancer uniquement le test de l'exercice en cours. Pour cela, ouvrir le 
fichier contenant le test, trouver la méthode de test, et dans la marge 
`clic gauche` sur l'icône de lancement ![run](../../../../../resources/run.png),
et choisir l'option *debug* ![debug](../../../../../resources/debug.png).

Pour arrêter le débugger à une instruction du programme, il faut placer des 
*breakpoints* ![breakpoint](../../../../../resources/breakpoint.png). Il suffit 
pour cela d'un `clic gauche` dans la marge du programme, sur le numéro de 
ligne. Un `clic droit` permet de le paramétrer si nécessaire, et un deuxième 
`clic gauche` le fait disparaître.

Lorsque le programme s'exécute, il s'interrompt automatiquement aux 
breakpoints, et affiche l'état de la pile.

![Panneau de débuggage](../../../../../resources/debug-panel.png)

Dans la partie gauche se trouve la liste des *frames*, c'est-à-dire des 
niveaux ou couches de la pile, la plus récente en haut. Attention, lancer un 
test demande un grand nombre d'appels de méthode avant d'arriver à la 
méthode de test, donc la plupart des *frames* ne sont pas pertinents, seuls 
les frames les plus hauts, pour lesquels on reconnaît les méthodes du projet,
nous intéressent.

La partie droite affiche le contenu du frame courant, en commençant par la 
valeur de `this` (si la méthode n'est pas statique), puis toutes les 
variables et leurs valeurs. Les tableaux et les objets peuvent être 
inspectés en dépliant les arborescences.

La barre du haut contient les actions réalisables, dont voici les plus 
importantes.

![Relancer](../../../../../resources/rerun.png) relance le test depuis le 
début, toujours en mode *debug*.

![Arrêter](../../../../../resources/stop.png) arrête l'évaluation du 
programme immédiatement, et ferme le débuggeur.

![Reprendre](../../../../../resources/resume.png) reprend l'évaluation, 
jusqu'au prochain *breakpoint* ou la fin normale de l'exécution du programme.

![Passer](../../../../../resources/step-over.png) passe à l'instruction 
suivante, en ignorant tout appel de méthodes dans l'instruction en cours.

![Entrer](../../../../../resources/step-into.png) passe à la première 
instruction d'une méthode appelée dans l'instruction en cours. En cas de 
choix entre plusieurs méthodes (ou constructeurs), il faut cliquer sur celle 
qui nous intéresse. Il est conseillé de ne pas entrer dans les méthodes ne 
faisant pas partie du projet.

![Sortir](../../../../../resources/step-out.png) reprend l'exécution jusqu'à 
terminer la méthode actuellement en cours, et s'interrompt à l'instruction 
ayant appelé la méthode.

Ces actions permettent d'exécuter le programme pas-à-pas, plus ou moins 
finement, en inspectant les valeurs des variables. 


Exercice 1
==========

Ce petit exercice vous permet de prendre en main le débugger d'IntelliJ.

- Vérifier que la méthode exécutable `main` de la classe `Main` (fichier `fr.
univamu.progav.Main.java`) appelle bien la méthode `exoDebug` d'une instance de 
  la classe `DebuggerTutorial` (sinon appeler l'enseignant).
- Exécuter le programme (tâche gradle run). Le programme doit afficher :
```
In method f.
In method g.
The end.
```
- Placer un *breakpoint* sur la première 
  ligne de la méthode `exoDebug` (comment ? lire ci-dessus). Relancer le 
  programme 
  en mode debug (bouton ![debug](../../../../../resources/debug.png) en haut 
  à droite). À l'issue de la compilation, vous obtiendrez l'ouverture de la 
  vue du debugger.
- Inspecter l'objet `this`. Quelles sont ses propriétés et leurs valeurs ? 
  Ceci correspond-il bien au programme écrit ?
- Avancer l'exécution d'une instruction 
  ![Passer](../../../../../resources/step-over.png). Quel est l'effet de 
  l'instruction ? 
- Entrer dans l'exécution de la méthode `f`
  ![Entrer](../../../../../resources/step-into.png). Combien la pile 
  a-t-elle de couches ? Quelles sont les valeurs de la variable `x` dans les 
  différentes couches de la pile ?
- Ressortir de la méthode `f`
  ![Sortir](../../../../../resources/step-out.png). Exécuter l'instruction 
  créant une instance de la classe `A` et vérifier son effet sur la mémoire. 
  Quelle est la référence du nouvel objet ?
- Sauter l'appel de la méthode `g`
  ![Passer](../../../../../resources/step-over.png).
- Ajouter un breakpoint après la boucle, puis reprendre l'exécution du 
  programme ![Reprendre](../../../../../resources/resume.png).
- Continuer jusqu'à voir le message de victoire dans le débugger. Sinon 
  recommencer.


Exercice 2
==========

Dans la classe `People`, la méthode `whereIsCharlie` devrait retourner la 
position de Charlie, 25 ans, dans la liste. Utiliser le test et le débuggeur 
pour trouver l'erreur.

Exercice 3
==========

Dans la classe `ASimpleLoop`, la méthode `nonTerminatingSum` fait un calcul, 
qui ne termine pas. Utiliser le test et le débuggeur, pour comprendre 
pourquoi elle ne termine pas. Corriger ensuite la méthode pour que le calcul 
s'arrête,

Exercice 4
==========

Dans la classe `Ratio`, représentant les nombres rationnels, l'addition ne 
semble pas produire le bon résultat. Pourtant, nous avons pris soin de bien 
réduire les fractions en calculant le plus grand commun diviseur avec 
l'algorithme d'Euclide, et de forcer cette réduction dans la méthode 
statique `of` que nous utilisons pour construire les fractions. Pour être 
sûr de bien tester, nous avons aussi ajouter une méthode `unsafeOf`, qui 
ignore l'étape de réduction : ainsi les valeurs attendues dans les tests 
sont certainement bien définies (nous les avons réduites nous-mêmes). Enfin, 
la méthode de test d'égalité profite de la forme réduite : il suffit de 
tester l'égalité des numérateurs et des dénominateurs. Utiliser la méthode 
de test et le débuggeur pour trouver l'erreur et la corriger. 


Exercice 5
==========

La classe `GuessingGame` reprend la stratégie optimale pour le jeu 
consistant à trouver un entier d'un intervalle (par exemple entre 1 et 1000),
en tentant des valeurs, et en obtenant pour chaque mauvaise réponse une 
indication "plus petit" ou "plus grand". Bien sûr, il s'agit de faire une 
recherche dichotomique. Ici, une erreur a été faite, et la dichotomie ne 
termine pas toujours. Il va d'abord falloir trouver une valeur mystère pour 
laquelle l'algorithme boucle infiniment (provoquant un dépassement de pile). 
Ensuite, en utilisant le débuggeur et en partant avec cette valeur, il sera 
possible de repérer la raison pour laquelle l'algorithme boucle ainsi. 
Utiliser donc une fois de plus le débugger pour trouver et corriger l'erreur.