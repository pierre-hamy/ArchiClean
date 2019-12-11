# Kata-List

| Nom | Langage | Durée | From scratch ? | Tests existants ? | Solution ? | Apprentissages | Cas d'utilisation (ex : recrutement n1, formation TDD02, etc) | Mises à jour nécessaires ? |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| [Elo Chart](EloChart/README.md) |  | < 3 hours | oui | non | non | Trouver une bonne liste de tests pour implémenter la formule |  |  |
| [Tennis Game](TennisGame/README.md) |  | < 3 hours | oui | non | non | Manipulation de la programmation objet |  | voir repo EmilyBache pour setup ? |
| [Game Of Life](GameOfLife/README.md) |  | < 3 hours | oui | non | non |  |  |  |
| [Online Shopping](OnlineShopping/README.md) |  | < 1 day | oui | non | non |  |  |  |
| [Archi Clean](https://github.com/octo-technology/Kata-List/tree/master/ArchiClean) | Java | 3 hours | non | oui | non | Refactoring API de GameOfLife |  | Java 8 |
| [Archi Clean](https://github.com/octo-technology/Kata-List/tree/master/ArchiClean) | Php | 3 hours | non | oui | non | Refactoring API de GameOfLife |  | ? |
| [Archi Clean](https://github.com/octo-technology/Kata-List/tree/master/ArchiClean) | Python | 3 hours | non | oui | non | Refactoring API de GameOfLife |  | - |
| [Puissance 4](https://www.codewars.com/kata/connect-4) |  | > 1 jour | oui | non | [java](https://github.com/victorenaud/power-4-kata) [javascript](https://github.com/rflipo-octo/puissance-4) | TDD from scratch | TDD01 |  |
| [Kata Bank](https://github.com/sandromancuso/Bank-kata) |  |  |  |  | Live code en outside-in de Sandro Mancuso |  | TDD01 |  |
| [Gilded rose](https://github.com/octo-technology/GildedRose-Refactoring-Kata) |  | 3 hours | non | oui | Live code FLA | Pose de tests de caractérisation (boîte noire), refacto | TDD02 |  |
| [Trip service](https://github.com/octo-technology/trip-service-kata) |  | 3 hours |  |  | Live code Sandro Mancuso | Casser des dépendances statiques, SRP, refacto | TDD02 |  |
| [Trivia](https://github.com/octo-technology/trivia) |  | > 1 jour |  |  |  | TDD from Legacy | TDD02 |  |
| [Mars Rover](https://github.com/octo-technology/mars-rover-starter) |  | 1 jour | oui | non | oui | Problématique d’extensibilité du code | TDD03 |  |
| [Mars Rover](https://github.com/EGI-OCTO/mars-rover-kata-kotlin) | Kotlin | | oui | non | oui | Problématique d’extensibilité du code |  |  |
| [Risk Game Of Thrones](https://gitlab.com/blndr/risk) |  | > 1 jour | oui | non | non | POO, Data structures |  |  |
| [Salle de sport](https://github.com/octo-technology/salle-de-sport-java) | java | 3 hours |  |  | [java](https://github.com/octo-technology/salle-de-sport-java) | Comprendre l'intérêt d'avoir plus d'un bounded context | DDD01 |  |
| [Salle de sport](https://github.com/octo-technology/salle-de-sport-kotlin) | Kotlin | 3 hours |  |  | [Kotlin](https://github.com/octo-technology/salle-de-sport-kotlin) | Comprendre l'intérêt d'avoir plus d'un bounded context | DDD01 |  |
| [Kuzco](https://github.com/jcraftsman/hotel-cuzco) |  | 1 jour | oui | non | oui |  |  |  |
| [kata-theater](https://github.com/emilybache/Theater-Kata) |  |  | oui | oui | non |  |  |  |
| [Transitive Dependencies](http://codekata.com/kata/kata18-transitive-dependencies/) |  |  | oui | non | non | Data structures |  |  |
| [Bowling]() |  | 3 hours |  |  | cf CTH |  |  |  |
| [CQRS and Event Sourcing Koans](https://github.com/DevLyon/mixter) |  |  |  |  |  | L'event sourcing |  |  |
| [Roman Numerals](http://codingdojo.org/kata/RomanNumerals/) | Kotlin |  | oui |  | [ici](https://github.com/EGI-OCTO/roman-numerals-kata-kotlin) | TDD, refacto par duplications, récursivité, baby steps, [Règle de trois](https://en.wikipedia.org/wiki/Rule_of_three_(computer_programming)) |  | non |
| [Diamond](https://github.com/ToF-/DiamondKata) | Haskell |  | oui |  | [ici](https://github.com/ToF-/DiamondKata) | Property based testing, bases d'Haskell |  | non |
| [Diamond](https://github.com/EGI-OCTO/diamond-kata-kotlin-PBT) | Kotlin |  | oui |  | [ici](https://github.com/EGI-OCTO/diamond-kata-kotlin-PBT) | Property based testing |  | non |
| [URL Bar Runner](https://v6p9d9t4.ssl.hwcdn.net/html/1005038/index.html) |  |  |  |  |  |  |  |  |

# Starters-list

| Langage | Lien |
| --- | --- |
| Java | TODO |
| Javascript | TODO |
| Python | TODO |
| Kotlin | [ici](https://github.com/EGI-OCTO/kotlin-kata-starter) |

# Idées de contraintes

* Limite à 1 sur les niveaux d'indentations
* Pas de else
* Single return statement
* Pas de if
* Pas de switch
* Une seule méthode par classe
* Immutabilité
* Respecter la loi de Déméter
* Pas de type primitifs
* Pas de getters/setters
* Maximum deux attributs par classe
* Maximum 50 lignes de code par fichier
* Que des fonctions, pas de classe
* TCR
* Baby steps : revert toutes les 2 minutes si les tests ne sont pas verts
* Pas d'exceptions comme valeur de retour
* Pas de variables globales
* Pas de valeurs de retour
* Pas de debugger ni "printf"
* Mute ping-pong si en pair
* Pas de boucles. Récursif, map, stream
* Que des exceptions

**Sources**

* https://williamdurand.fr/2013/06/03/object-calisthenics/
* http://kata-log.rocks/constraint.html

# Contributing

Pour enrichir la liste, les règles  sont les suivantes :
* un repo = un kata dans un seul langage
* un README pour :
  * présenter le kata
  * objectif(s) pédagogique(s) du kata (pour faciliter la préparation d'une formation, d'un recrutement, etc)
  * expliquer le setup
* optionnel : une branche `solution` pour proposer une solution, avec des pistes de résolution, un step-by-step, ou plusieurs commits pour montrer les étapes de résolution du kata, etc

# TODO

Reste à faire, priorisé :
* Extraire les 3 langages principaux pour les katas qui les ont déjà
* Mettre à jour les versions des katas existants si besoin (exemple : PR sur les repos existants)
* Remplir la section des starters en Java, JS, Python
* Proposer des solutions aux katas de la liste qui n'en ont pas encore
* Autre exemples d'exercices/katas : [exercism.io](https://exercism.io)
