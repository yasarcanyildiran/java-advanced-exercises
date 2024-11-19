Ces exercices portent sur la gestion des exceptions. Le contexte est la 
gestion des livres d'une bibliothèque, qui n'est pas un exemple très 
pertinent pour l'utilisation d'exceptions, mais qui a l'avantage d'être 
relativement simple pour apprendre les bases de la manipulation des exceptions.

La bibliothèque ```Library``` possède une collection de livres ```Book```, et 
les clients peuvent venir emprunter un ou plusieurs livres (méthodes 
```checkoutBook``` et ```checkoutBooks```). Un livre peut donc être 
disponible ou indisponible (classe ```BookStatus```), ou bien ne pas faire 
partie de la bibliothèque.

Si un client veut emprunter un livre déjà prêté, l'exception 
```BookUnavailableException``` sera levée. Si le livre n'est pas possédé par la 
bibliothèque, l'exception ```BookNotFoundException``` sera levée.

Exercice 1
==========

Compléter les 2 extensions ```BookNotFoundException``` (possédant un code 
ISBN) et ```BookUnavailable``` (possédant un livre) de la 
classe```BookException```. Assurez-vous que la méthode ```getMessage``` de 
chacune délivre un message adapté et mentionnant soit le code ISBN, soit le 
livre concerné.

Exercice 2
==========

Compléter la méthode ```findBook``` de la classe ```Library```. Elle doit 
retourner le livre dont le code ISBN est fourni. S'il n'existe pas un tel 
livre, il faut émettre l'exception ```BookNotFoundException```. Ajouter la 
déclaration d'exception à la méthode.

Exercice 3
==========

Compléter la méthode ```checkBookStatus``` de la classe ```Library```, 
retournant le status d'un livre précisé par son code ISBN. Si le livre 
n'existe pas, l'exception ```BookNotFound``` sera émise. Ajouter la
déclaration d'exception à la méthode.

Exercice 4
==========

Compléter la méthode ```checkoutBook``` de la classe ```Library```.
La méthode vérifie l'existence et la disponibilité du livre (donné par son 
code ISBN), et modifie alors son status à ```BORROWED```. Si les conditions 
ne sont pas respectées, la méthode émet l'exception appropriée. Ajouter la
déclaration d'exception à la méthode.

Exercice 5
==========

Compléter la méthode ```isCompletelySuccessful``` de la classe 
```BulkCheckoutResult```. Cette classe contiendra les résultats de la 
réservation d'une liste de livres, comprenant :
- la liste des livres empruntés;
- la liste des échecs des tentatives d'emprunt.

Exercice 6
==========

Compléter la méthode ```checkoutBooks``` de la classe ```Library```.


Vérifier votre travail à l'aide des tests fournis.