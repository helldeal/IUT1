# TP1 : les bases de l'utilisation d'un débugueur

Le TP d'aujourd'hui vise à vous donner les principe de base de l'utilisation d'un débugueur, un outil qui permet d'exécuter du code pas à pas (c'est-à-dire, à peu de choses près, ligne par ligne) et d'examiner à chaque pas l'état de la mémoire (valeurs des variables, etc).

<ins>Utiliser un tel outil vous permettra :</ins>
1. dans un premier temps de pouvoir plus simplement **débuguer vos programmes** qu'en faisant des affichages dans le terminal et,
2. dans un second temps, lorsque vous serez familiers avec la notion de code machine, de regarder le code produit par la compilation d'un programme, de l'exécuter, de mieux le comprendre et ainsi d'**optimiser vos programmes**.

## Le débugueur Delve

Puisque nous travaillerons sur des programmes écrits en Go nous utiliserons le débugueur [Delve](https://github.com/go-delve/delve), lui-même écrit en Go et qui semble, à l'heure actuelle, être celui qui est choisi par la plupart des développeurs qui travaillent avec ce langage.
Notez cependant qu'il est possible d'utiliser d'autres débugueurs, pas spécifiquement orientés vers le Go, [comme GDB par exemple](https://go.dev/doc/gdb).

Vous pouvez installer Delve sur vos machines à l'IUT (ou sur vos machines personnelles) en suivant les [instructions officielles pour l'installation](https://github.com/go-delve/delve/tree/master/Documentation/installation).
Pour connaître votre version de Go il suffit d'utiliser la commande `go version`.
Si votre version est antérieure à la version `go1.16`, elle n'est pas compatible avec la version courante de delve (`v1.8.0` à l'heure d'écrire ce sujet).
Vous devez alors installer une version antérieure de delve, par exemple la version `v1.6.0`.
Cela peut se faire commme suit :

```bash
$ git clone https://github.com/go-delve/delve
$ cd delve
$ git checkout v1.6.0
$ go install github.com/go-delve/delve/cmd/dlv
```

Par défaut, l'outil sera installé dans votre espace de travail Go (`~/go/bin`) si vous n'avez rien changé à la configuration par défaut.
Vous pouvez ajouter ce répertoire dans votre `PATH` pour pouvoir utiliser directement la commande `dlv` pour invoquer Delve.
Sinon, vous pouvez toujours l'utiliser avec la commande `~/go/bin/dlv`. 

## Un cas d'étude

Dans tout ce TP nous travaillerons sur le code suivant, que vous devriez normalement comprendre sans trop de problèmes :
```go
package main

import "fmt"

func main() {
    var t []int = []int{12, 34, 9, 27, 14}
    for i := 0; i < len(t) - 1; i++ {
        minpos := minimumPosition(t[i:])
        t[i], t[i+minpos] = t[i+minpos], t[i]
    }
    fmt.Println(t)
}

func minimumPosition(t []int) (pos int) {
    for i := 1; i < len(t); i++ {
        if t[i] < t[pos] {
            pos = i
        }
    }
    return pos
}
```

## Commandes de base

Pour exécuter le débugueur sur un programme Go `monprog.go` quelconque (comprenant un main) il suffit d'utiliser la commande `dlv debug monprog.go`.
On a alors une invite `(dlv)` qui va permettre de donner des commandes au débugueur pour interagir avec le programme.

1. Exécutez Delve sur le programme ci-dessus

### continue : exécuter un programme

La commande `continue` permet d'exécuter le programme qui a été donné au débugueur.

2. Utilisez la commande `continue`. 
    - Que fait le programme sur lequel vous travaillez ?
    - Quelles informations vous donne Delve ?
3. Utilisez à nouveau la commande `continue`.
    - Que constatez-vous ?

### restart : recommencer l'exécution

La commande `restart` permet de recharger le programme pour pouvoir l'exécuter de nouveau.

4. Utilisez la commande `restart` puis à nouveau `continue`.

### break : points d'arrêt

La commande `break` permet de créer un point d'arrêt, c'est-à-dire d'identifier un endroit dans le programme où toute exécution s'arrêtera si elle l'atteint.
Avec `break monprog.go:ligne` on crée un point d'arrêt à la ligne numéro `ligne` du fichier `monprog.go`.
Avec `break minimumPosition` on crée un point d'arrêt à la fonction `minimumPosition`.

5. Créez un point d'arrêt à la première ligne du `main`.
    - Que se passe-t-il en faisant `continue` ?
    - Comment atteindre la fin du programme ?
6. Créez un point d'arrêt à la fonction `minimumPosition`.
    - Que se passe-t-il en faisant plusieurs fois `continue` ?

### list : voir le code

À tout moment vous pouvez utiliser la commande `list` pour voir le code du programme ne cours (comme ce qui est affiché lorsqu'on s'arrête à un point d'arrêt).

### breakpoints : lister les points d'arrêt

La commande `breakpoints` permet de lister tous les points d'arrêts actuellement existants.

7. Utilisez la commande `breakpoints`
    - Que remarquez-vous ?

### clear et clearall : supprimer des points d'arrêt

La commande `clear bp` supprime le point d'arrêt numéro `bp` (on peut obtenir les numéros avec `breakpoints`) et la commande `clearall` supprime tous les points d'arrêt.

8. Supprimez les points d'arrêt que vous aviez ajoutés aux questions précédentes.

### print : afficher des valeurs de variables

La commande `print x` permet d'afficher la valeur de la variable `x` au moment où l'exécution s'est arrêtée.

9. Ajoutez un point d'arrêt à la fonction `minimumPosition`.
    - Que vaut le tableau `t` au premier appel à cette fonction ?
    - Que vaut `t` au deuxième appel à cette fonction ?
10. Supprimez tous les points d'arrêt et rechargez le programme.

### step et next : exécution pas à pas

Les commandes `step` et `next` permettent d'avancer ligne de code par ligne de code dans un programme.

11. Placez un point d'arrêt au début de la boucle `for` du `main` puis faites progresser le programme jusque là. Utilisez alors quelques fois la commande `next` et quelques fois la commande `step`.
    - Quelle différence fondamentale voyez-vous entre ces deux commandes ?

## Commandes plus avancées

### stack : visualiser la pile d'appel

La commande `stack` permet de visualiser les fonctions appelées.

12. Placez-vous à un moment de l'exécution où la fonction `minimumPosition` est en train d'être exécutée. Utilisez alors la commande `stack`.
    - Expliquez ce que vous observez.

### disassemble : voir le code machine

La commande `disassemble` permet de visualiser le code machine (c'est-a-dire le code qui est vraiment exécuté par l'ordinateur) correspondant au programme Go en cours de débugage.

13. Placez-vous à un moment quelconque de l'exécution de votre programme et utilisez la commande `disassemble`.
    - Discutez ce que vous observez.
    - Arrivez-vous à faire un peu le lien avec le code Go ?

## Références

- [Commandes de Delve](https://github.com/go-delve/delve/tree/master/Documentation/cli)

P.-S. On peut aussi quitter le débugueur avec la commande `quit`
