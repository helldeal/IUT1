# TP9 : exceptions

(merci à J-F Remm pour les idées d'exercices)

## exo 1 : résolution d'adresse

Le programme fourni dans `exo1.Resolution.kt` permet d'obtenir l'IPv4 d'une machine à partir de son nom 
(`wikipedia.fr`, `mediapart.fr`, `kotlinlang.org` ou même `infoweb` (sur le réseau de l'IUT)).

Mais que se passe-t-il si vous saisissez un nom invalide ? 

Corrigez le programme pour qu'il affiche un message d'erreur mais ne plante pas ; 
procédez de deux manières (successivement) : 
- dans la méthode `main()` ou 
- dans la méthode `nomVersIP()`

## exo 2 : validation de saisie

Le programme fourni dans `exo2.Validation.kt` demande la saisie d'une chaine de caractères et la convertit
en un double. Cela marche pour `42.0`, `42`, `-42.0`

Que se passe-t-il si vous saisissez une valeur invalide ? ex : `totoro`

On souhaite corriger la fonction `donneDoubleSaisi()` ainsi :
1. demande d'une saisie
2. saisie
3. tentative de conversion
4. si échec alors on recommence en 1. tout en indiquant qu'il y a eu un problème
On repèrera l'échec de conversion grâce à l'exception `NumberFormatException` levée 


## exo 3 : pile d'entiers'

Le code d'une pile d'entiers vous est fourni dans `exo3.pile.Pile`
Modifiez ce code pour que des exceptions soient lancées 
- `IllegalArgumentException` si la taille de la pile est inférieure ou égale à 0
- `PileException` si on essaie de dépiler une pile vide
- `PileException` si on essaie d'empiler dans une pile pleine

## exo 4 : usage d'une pile d'entiers'

Dans `exo4.Programme.kt` écrivez un programme interactif (en mode console) permettant de
- initialiser une pile avec une taille aléatoire tirée entre -10 et 10
- choisir entre empiler une valeur ou dépiler une valeur dans la pile

Bien entendu, vous utiliserez `exo3.Pile`  : comme vous ne pouvez pas utiliser 
`estVide()` ou `estPleine()` qui sont `private`, 
vous devrez utiliser les exceptions `PileException` levées 
afin de vous assurer que votre programme ne plante jamais.


## exo 5 : notation polonaise inversée

Utilisez une `exo3.pile.Pile` pour évaluer une expression (chaine de caractères)
exprimée en notation polonaise inversée (ou postfixée) : 
`(2+8)/2` s'exprime en polonais inversé ainsi : `2 8 + 2 /`

Le principe est le suivant :
- On utilise une pile d'entiers
- Quand on rencontre un entier, on l'empile
- Quand on rencontre un opérateur (`op` = `+`, `-`, `*` ou `/`), on dépile deux fois 
pour obtenir les opérandes `b`, puis `a`), on 
résout `a op b`, ré-empile le résultat, et on continue

Considérons `2 8 + 2 /`
- On lit `2` : on empile `2`
- On lit `8` : on empile `8`
- On lit `+` : on dépile `8`, on dépile `2`, on calcule `2 + 8 = 10`, on empile `10`
- On lit `2` : on empile `2`
- On lit `/` : on dépile `2`, on dépile `10`, on calcule `20 / 2 = 5`, on empile `5`
- On a fini : on dépile le résultat = `5`

Implémentez cela dans `exo5.Polonaise.kt`

## Exo 6 : rationnels

Corrigez la classe `Rational` pour utiliser des exceptions pour signaler les erreurs possibles dans le constrcuteur
et dans certaines opérations.
